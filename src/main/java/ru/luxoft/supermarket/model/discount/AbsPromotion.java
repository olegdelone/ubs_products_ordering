package ru.luxoft.supermarket.model.discount;

/**
 * Created by olegdelone on 10.12.2015.
 */
public abstract class AbsPromotion {
    final int amount;

    public AbsPromotion(int amount) {
        this.amount = amount;
    }
}
