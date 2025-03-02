package org.skypro.skyshop.model;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int fixPrice = 399;

    public FixPriceProduct(String name, UUID id) {
        super(name, id);
    }

    @Override
    public int getPrice() {
        return this.fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
