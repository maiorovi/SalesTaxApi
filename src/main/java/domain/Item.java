package domain;

import org.springframework.util.Assert;

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
        Assert.isTrue(count > 0, "Count should be positive");
        this.count = count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        Assert.isTrue(count > 0, "Price should be greater or equal to 0");
        this.unitPrice = unitPrice;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (count != item.count) return false;
        if (Double.compare(item.unitPrice, unitPrice) != 0) return false;
        if (imported != item.imported) return false;
        return description != null ? description.equals(item.description) : item.description == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = description != null ? description.hashCode() : 0;
        result = 31 * result + count;
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (imported ? 1 : 0);
        return result;
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
