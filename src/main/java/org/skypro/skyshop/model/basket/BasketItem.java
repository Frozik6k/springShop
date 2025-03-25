package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(product, count);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null && getClass() != obj.getClass()) return false;
        BasketItem basketItem = (BasketItem) obj;
        return Objects.equals(product, basketItem.product) && Objects.equals(count, basketItem.count);
    }

}
