package org.skypro.skyshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {

    private String name;

    private final UUID id;

    public Product(String name, UUID id) {
        this.id = id;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Отсутствует название продукта");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @JsonIgnore
    @Override
    public String searchTerm() {
        return getName();
    }

    @JsonIgnore
    @Override
    public String getContent() {
        return "PRODUCT";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.contains(product.getName());
    }

    @Override
    public UUID getId() {
        return id;
    }
}


