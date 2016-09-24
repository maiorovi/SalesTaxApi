package domain;

public class Item {
    private String description;
    private int count;
    private double unitPrice;
    private boolean imported;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", count=" + count +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
