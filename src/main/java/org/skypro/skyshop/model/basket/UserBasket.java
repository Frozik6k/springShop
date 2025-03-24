package org.skypro.skyshop.model.basket;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(products, total);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserBasket userBasket = (UserBasket) obj;
        return Objects.equals(total, userBasket.total) && Objects.equals(products, userBasket.products);
    }

    @Override
    public String toString() {
        return products.toString() + " " + total;
    }
}
