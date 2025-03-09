package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.Product;

import java.util.Collections;
import java.util.List;

final public class BasketItem {
    final private Product product;

    private int count;

    public BasketItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }
}
