package org.skypro.skyshop.controller.error;

public class NoSuchProductException extends RuntimeException {
    // Конструктор по умолчанию
    public NoSuchProductException() {
        super("Нет такого товара в корзине");
    }
}
