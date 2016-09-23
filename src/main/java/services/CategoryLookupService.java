package services;

import providers.ItemCategoryDataProvider;
import util.ItemCategorie;

import java.util.Map;

public class CategoryLookupService {

    private ItemCategoryDataProvider dataProvider;

    public CategoryLookupService(ItemCategoryDataProvider itemCategoryDataProvider) {
        this.dataProvider = itemCategoryDataProvider;
    }

    public ItemCategorie lookUpCategory(String description) {
        return dataProvider.getCatalog().getOrDefault(description, ItemCategorie.OTHER);
    }
}
