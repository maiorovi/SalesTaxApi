package services;

import domain.Item;
import util.ItemCategorie;

import java.text.DecimalFormat;
import java.util.List;

public class TaxCalculationService {

    private static final Double TAX_RATE = 0.1;
    private CategoryLookupService categoryLookupService;

    public TaxCalculationService(CategoryLookupService categoryLookupService) {
        this.categoryLookupService = categoryLookupService;
    }

    public Double calculateTax(Item item) {
        double result = 0;

        if (shouldCalculateTax(item)) {
            result = (item.getUnitPrice() * item.getCount() * TAX_RATE);
        }

        return result;
    }

    public Double calculateTax(List<Item> items) {
        double sum = 0.0;

        sum = items.stream().map(this::calculateTax).reduce(0d, Double::sum);

        return roundPrice(sum);
    }

    private boolean shouldCalculateTax(Item item) {
        return categoryLookupService.lookUpCategory(item.getDescription()) == ItemCategorie.OTHER;
    }

    private Double roundPrice(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return Double.valueOf(decimalFormat.format(value));
    }

}
