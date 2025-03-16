package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.Product;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    final private Map<UUID, Integer> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(UUID id) {
        products.put(id, 1 + Optional.ofNullable(products.get(id)).orElse(0));
    }

    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }
}
