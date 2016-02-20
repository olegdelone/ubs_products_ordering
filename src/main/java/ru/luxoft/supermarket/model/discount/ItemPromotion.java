package ru.luxoft.supermarket.model.discount;

import ru.luxoft.supermarket.model.item.AbsItem;

/**
 * Created by olegdelone on 10.12.2015.
 */
public interface ItemPromotion {
    boolean supports(AbsItem item);
    int getDiscount(AbsItem item);
}
