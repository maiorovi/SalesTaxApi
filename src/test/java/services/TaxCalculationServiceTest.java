package services;

import domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import util.ItemCategorie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculationServiceTest {
    private final static Boolean IMPORTED = Boolean.TRUE;
    private final static Boolean NOT_IMPORTED = Boolean.FALSE;

    @Mock
    private CategoryLookupService categoryLookupService;
    @InjectMocks
    private TaxCalculationService taxCalculationService;

    @Test
    public void onlyBasicTaxIsIncludedWhenItemIsNotImportedAndNotExempt() throws Exception {
        Item item = mockItem("Computer", 25.0, 5, NOT_IMPORTED);

        when(categoryLookupService.lookUpCategory("Computer")).thenReturn(ItemCategorie.OTHER);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(12.5);
    }

    @Test
    public void noTaxAreChargedForExemptAndNotImportedItem() {
        Item item = mockItem("Chocolate", 25.0, 5, NOT_IMPORTED );

        when(categoryLookupService.lookUpCategory("Chocolate")).thenReturn(ItemCategorie.FOOD);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(0);
    }

    @Test
    public void forExemptAndImportedItemsImportTaxIsCharged() {
        Item item = mockItem("Chocolate", 25.0, 5, IMPORTED );

        when(categoryLookupService.lookUpCategory("Chocolate")).thenReturn(ItemCategorie.FOOD);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(6.25);
    }

    @Test
    public void forNonExemptAndImportedItemsTaxIsCharged() {
        Item item = mockItem("Computer", 25.0, 5, IMPORTED );

        when(categoryLookupService.lookUpCategory("Computer")).thenReturn(ItemCategorie.OTHER);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(18.75);
    }

    @Test
    public void calculatedTaxIsZeroForNotImportedFood() {
        Item item = mockItem("Computer", 25.0, 5, NOT_IMPORTED);

        when(categoryLookupService.lookUpCategory("Computer")).thenReturn(ItemCategorie.FOOD);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(0);
    }

    @Test
    public void calculatedTaxIsZeroForNotImportedBook() {
        Item item = mockItem("Book", 25.0, 5, NOT_IMPORTED);

        when(categoryLookupService.lookUpCategory("Book")).thenReturn(ItemCategorie.BOOK);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(0);
    }

    @Test
    public void calculatedTaxIsZeroForNotImportedMedicine() {
        Item item = mockItem("Medicine", 25.0, 5, NOT_IMPORTED);

        when(categoryLookupService.lookUpCategory("Medicine")).thenReturn(ItemCategorie.MEDICINE);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(0);
    }

    @Test
    public void amountIsTakenIntoAccountForCalculationOfTaxes() {
        Item item = mockItem("Computer", 25.0, 5, IMPORTED);

        when(categoryLookupService.lookUpCategory("Computer")).thenReturn(ItemCategorie.OTHER);

        assertThat(taxCalculationService.calculateTax(item).getSalesTaxAmount()).isEqualTo(18.75);
    }

    private Item mockItem(String description, double price, int count,boolean isImported) {
        Item item = mock(Item.class);

        when(item.getDescription()).thenReturn(description);
        when(item.getUnitPrice()).thenReturn(price);
        when(item.getCount()).thenReturn(count);
        when(item.isImported()).thenReturn(isImported);

        return item;
    }


}
