package org.skypro.skyshop.service;

import org.skypro.skyshop.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class StorageService {


    private final Map<UUID, Article> articles;
    private final Map<UUID, Product> products;

    public StorageService() {
        this.articles = new HashMap<>();
        this.products = new HashMap<>();
        addProductAndArticle();
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    private void addProductAndArticle() {
        UUID id = UUID.randomUUID();
        products.put(id, new SimpleProduct("Носки", id, 100));
        id = UUID.randomUUID();
        products.put(id, new DiscountedProduct("Носки", id, 200, 10));
        id = UUID.randomUUID();
        products.put(id, new FixPriceProduct("Книга", id));
        id = UUID.randomUUID();
        products.put(id, new FixPriceProduct("Кофта", id));
        id = UUID.randomUUID();
        products.put(id, new DiscountedProduct("Брюки", id, 500, 30));

        id = UUID.randomUUID();
        articles.put(id, new Article("Носки", "Спортивные носки", id));
        id = UUID.randomUUID();
        articles.put(id, new Article("Кофточка", "Самая лучшая кофточка", id));
        id = UUID.randomUUID();
        articles.put(id, new Article("Носки", "Спортивные носки Adic", id));
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(getProducts().get(id));
    }

}
