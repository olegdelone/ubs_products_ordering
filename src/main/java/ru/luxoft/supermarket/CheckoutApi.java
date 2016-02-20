package ru.luxoft.supermarket;

import ru.luxoft.supermarket.model.discount.GlobalPromotion;
import ru.luxoft.supermarket.model.discount.ItemCountPromotion;
import ru.luxoft.supermarket.model.discount.ItemPromotion;
import ru.luxoft.supermarket.model.item.Bread;
import ru.luxoft.supermarket.model.item.Butter;
import ru.luxoft.supermarket.model.item.AbsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olegdelone on 08.12.2015.
 */
public class CheckoutApi implements CheckoutableApi {

    private final List<AbsItem> cart = new ArrayList<>();
    private final List<ItemPromotion> itemPromotions = new ArrayList<ItemPromotion>() {{

        add(new ItemCountPromotion(Bread.class, 3, 5));
        add(new ItemCountPromotion(Butter.class, 4, 6));
    }};
    private final List<GlobalPromotion> globalPromotions = new ArrayList<GlobalPromotion>() {{
        add(new GlobalPromotion(8, 2));
    }};


    @Override
    public int total() {
        int r = 0;
        int d = 0;
        for (AbsItem item : cart) {
            for (ItemPromotion itemPromotion : itemPromotions) {
                if(itemPromotion.supports(item)){
                    d += itemPromotion.getDiscount(item);
                }
            }
            r += item.getPrice()*item.getCount();
        }

        for (GlobalPromotion globalPromotion : globalPromotions) {
            d += globalPromotion.getDiscount(cart);
        }
        return r - d;
    }

    @Override
    public void scan(AbsItem item) {
        if (item == null) {
            throw new IllegalArgumentException("arg [item] cannot be null");
        }
        cart.add(item);
    }
}
