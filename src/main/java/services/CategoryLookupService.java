package services;

import providers.ItemCategoryDataProvider;
import util.ItemCategorie;

import java.util.Map;

public class CategoryLookupService {

    private ItemCategoryDataProvider dataProvider;

    public CategoryLookupService(ItemCategoryDataProvider itemCategoryDataProvider) {
        if (itemCategoryDataProvider == null) {
            throw new IllegalArgumentException("ItemCategoryDataProvider is null");
        }
        this.dataProvider = itemCategoryDataProvider;
    }

    public ItemCategorie lookUpCategory(String description) {
        if (description == null) {
            throw  new IllegalArgumentException();
        }

        return dataProvider.getCatalog().getOrDefault(description, ItemCategorie.OTHER);
    }
}
