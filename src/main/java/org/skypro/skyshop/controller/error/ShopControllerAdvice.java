package org.skypro.skyshop.controller.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {

    // Глобальный обработчик исключений NoSuchProductException
    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException (NoSuchProductException e) {
        // Возвращаем статус 400 Bad Request с сообщением об ошибке
        return ResponseEntity.badRequest().body(new ShopError("товар не найден", "Товар который вы хотите добавить, нет в наличии"));
    }
}

