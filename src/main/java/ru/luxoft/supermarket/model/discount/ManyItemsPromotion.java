package ru.luxoft.supermarket.model.discount;

import ru.luxoft.supermarket.model.item.AbsItem;

import java.util.Collection;

/**
 * Created by olegdelone on 10.12.2015.
 */
public interface ManyItemsPromotion {
    int getDiscount(Collection<AbsItem> item);
}
