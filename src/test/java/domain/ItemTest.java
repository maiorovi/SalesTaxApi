package domain;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    private Item item;

    @Before
    public void setUp() {
        item = new Item();
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionIsThrownIfAmountIsZero() {
        item.setCount(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionIsThrownIfAmountIsNegative() {
        item.setCount(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionIsThrownIfPriceIsNegative() {
        item.setUnitPrice(-10);
    }
}
