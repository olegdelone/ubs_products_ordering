package ru.luxoft.supermarket.model.discount;

import ru.luxoft.supermarket.model.item.AbsItem;

import java.util.Collection;

/**
 * Created by olegdelone on 10.12.2015.
 */
public class GlobalPromotion extends AbsPromotion implements ManyItemsPromotion {

    int requiredCnt;

    public GlobalPromotion(int requiredCnt, int amount) {
        super(amount);
        this.requiredCnt = requiredCnt;
    }

    @Override
    public int getDiscount(Collection<AbsItem> item) {
        int r = 0;
        int size = item.stream().mapToInt(AbsItem::getCount).sum();
        if (size > requiredCnt) {
            r = amount;
        }
        return r;
    }
}
