package domain;

public class SalesTaxItem {
    private double salesTaxAmount;

    public SalesTaxItem(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }
}
