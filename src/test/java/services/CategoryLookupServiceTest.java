package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import providers.ItemCategoryDataProvider;
import util.ItemCategorie;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static util.ItemCategorie.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryLookupServiceTest {

    @Mock
    private ItemCategoryDataProvider itemCategoryDataProvider;
    @InjectMocks
    private CategoryLookupService categoryLookupService;

    @Test
    public void retrievesCategoryByDescriptionUsingDataProvider() {
        HashMap<String,ItemCategorie> map = mock(HashMap.class);
        itemCategoryDataProvider.getCatalog();


        when(itemCategoryDataProvider.getCatalog()).thenReturn(map);
        when(map.getOrDefault("Chocolate", OTHER)).thenReturn(FOOD);
        when(map.getOrDefault("Computer", OTHER)).thenReturn(OTHER);

        verify(itemCategoryDataProvider).getCatalog();
        assertThat(categoryLookupService.lookUpCategory("Chocolate")).isEqualTo(FOOD);
        assertThat(categoryLookupService.lookUpCategory("Computer")).isEqualTo(OTHER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPassedToConstructorCausesIllegalArgumentException() {
        new CategoryLookupService(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPassedAsADescriptionCauseIlegalArgumenException() {
        categoryLookupService.lookUpCategory(null);
    }



}
