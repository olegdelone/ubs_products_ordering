package ru.luxoft.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ru.luxoft.supermarket.CheckoutApi;
import ru.luxoft.supermarket.CheckoutableApi;
import ru.luxoft.supermarket.model.item.Bread;
import ru.luxoft.supermarket.model.item.Butter;
import ru.luxoft.supermarket.model.item.AbsItem;

/**
 * Created by olegdelone on 08.12.2015.
 */
public class TestClass {
    CheckoutableApi api;

    @Before
    public void init(){
        api = new CheckoutApi();
    }

    @Test
    public void totalZeroCheck() {
        Assert.assertSame(0, api.total());
    }

    @Test
    public void totalNonZeroCheck() {
        AbsItem item = Mockito.mock(AbsItem.class);
        Mockito.when(item.getPrice()).thenReturn(5);
        api.scan(item);

        Assert.assertSame(5, api.total());
    }

    @Test(expected = IllegalArgumentException.class)
    public void totalNullCheck() {
        api.scan(null);
    }

    @Test()
    public void promotionCheck() {
        AbsItem bread = new Bread(10, 4); // 40
        AbsItem butter = new Butter(80, 5); // 400
        // -2 global for 8 prod
        // -5 for 3 bread
        // -6 for 4 butter
        api.scan(bread);
        api.scan(butter);
        Assert.assertEquals(440 - 13, api.total());
    }
}
