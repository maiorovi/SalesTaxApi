package domain;

public class SalesTaxItem {
    private double salesTaxAmount;

    public SalesTaxItem(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesTaxItem that = (SalesTaxItem) o;

        return Double.compare(that.salesTaxAmount, salesTaxAmount) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(salesTaxAmount);
        return (int) (temp ^ (temp >>> 32));
    }
}
