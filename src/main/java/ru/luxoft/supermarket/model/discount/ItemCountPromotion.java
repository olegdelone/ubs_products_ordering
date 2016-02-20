package ru.luxoft.supermarket.model.discount;

import ru.luxoft.supermarket.model.item.AbsItem;

/**
 * Created by olegdelone on 10.12.2015.
 */
public class ItemCountPromotion extends AbsPromotion implements ItemPromotion {
    private final Class<? extends AbsItem> clazz;

    public boolean supports(AbsItem item){
        return item.getClass() == clazz;
    }

    private int requiredCount;

    public ItemCountPromotion(Class<? extends AbsItem> clazz, int requiredCount, int amount) {
        super(amount);
        this.clazz = clazz;
        this.requiredCount = requiredCount;
    }

    @Override
    public int getDiscount(AbsItem item) {
        if(!supports(item)){
            throw new IllegalArgumentException("arg [item] must be supportable: given=>"+item.getClass().getSimpleName()
            +"; expected=>" + clazz.getSimpleName());
        }
        int result = 0;
        if(item.getCount() >= requiredCount){
            result = amount;
        }
        return result;
    }
}
