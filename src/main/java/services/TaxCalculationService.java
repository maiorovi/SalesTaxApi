package services;

import domain.Item;
import domain.SalesTaxItem;
import util.ItemCategorie;

import java.text.DecimalFormat;
import java.util.List;

public class TaxCalculationService {

    private static final Double TAX_RATE = 0.1;
    private static final Double IMPORT_RATE = 0.05;
    private CategoryLookupService categoryLookupService;

    public TaxCalculationService(CategoryLookupService categoryLookupService) {
        this.categoryLookupService = categoryLookupService;
    }

    public SalesTaxItem calculateTax(Item item) {
        double result = 0;
        double totalPrice = item.getUnitPrice() * item.getCount();

        if (shouldCalculateTax(item)) {
            result = ( totalPrice * TAX_RATE);
        }

        if(item.isImported()) {
            result += (totalPrice * IMPORT_RATE);
        }

        return new SalesTaxItem(result);
    }

    public SalesTaxItem calculateTax(List<Item> items) {
        double sum = 0.0;

        sum = items.stream().map(this::calculateTax).map(it -> it.getSalesTaxAmount()).reduce(0d, Double::sum);

        return new SalesTaxItem(roundPrice(sum));
    }

    private boolean shouldCalculateTax(Item item) {
        return categoryLookupService.lookUpCategory(item.getDescription()) == ItemCategorie.OTHER;
    }

    private Double roundPrice(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return Double.valueOf(decimalFormat.format(value));
    }

}
