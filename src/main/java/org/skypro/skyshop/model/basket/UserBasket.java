package org.skypro.skyshop.model.basket;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> products;
    private final int total;

    public UserBasket(List<BasketItem> products) {
        this.products = products;
        this.total = products.stream()
                .map(value -> value.getProduct().getPrice() * value.getCount())
                .reduce(0, Integer::sum);
    }

    public List<BasketItem> getProducts() {
        return products;
    }

    public int getTotal() {
        return total;
    }


}
