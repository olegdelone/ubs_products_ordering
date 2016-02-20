package ru.luxoft.supermarket;

import ru.luxoft.supermarket.model.item.AbsItem;

/**
 * Created by olegdelone on 08.12.2015.
 */
public interface CheckoutableApi {
    int total();
    void scan(AbsItem item);
}
