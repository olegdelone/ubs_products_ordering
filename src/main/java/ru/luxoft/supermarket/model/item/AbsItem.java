package ru.luxoft.supermarket.model.item;

/**
 * Created by olegdelone on 08.12.2015.
 */
public abstract class AbsItem {
    int price;
    int count;

    public AbsItem(int price, int count) {
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
