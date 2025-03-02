package org.skypro.skyshop.model;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, UUID id, int price) {
        super(name, id);
        if (price < 1) throw new IllegalArgumentException("Цена не может быть меньше единицы");
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}

