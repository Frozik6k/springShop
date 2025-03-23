package org.skypro.skyshop.controller.error;

final public class ShopError {
    private String code;
    private String message;

    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
