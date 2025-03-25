package org.skypro.skyshop.service;

import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.controller.error.NoSuchProductException;
import org.skypro.skyshop.model.Product;
import org.skypro.skyshop.model.SimpleProduct;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;

import javax.management.relation.RoleList;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private StorageService storageService;

    @Mock
    private ProductBasket productBasket;

    @InjectMocks
    private BasketService basketService;

    @Test
    void giveUuid_whenProductNotFind_thenStorageServiceNoSuchProductException() {
        UUID uuid = UUID.randomUUID();

        Mockito.doThrow(NoSuchProductException.class).when(storageService).getProductById(uuid);

        Assertions.assertThrows(NoSuchProductException.class, () -> {
            basketService.addProduct(uuid);
        });
    }

    @Test
    void giveUuid_whenAddProduct_thenProductBasketAddProduct() {
        UUID uuid = UUID.randomUUID();

        basketService.addProduct(uuid);

        Mockito.verify(productBasket).addProduct(uuid);
    }

    @Test
    void whenProductBasketEmpty_thenGetUserBasketEmpty() {
        // productBasket по умолчанию создается с помощью конструктора пустой корзиной

        Assertions.assertEquals(new ArrayList<BasketItem>(), basketService.getUserBasket().getProducts());
    }

    @Test
    void giveUserBasket_whenProductBasketNotEmpty_thenGetUserBasketNotEmpty() {
        UUID uuid = UUID.randomUUID();
        Product product = new SimpleProduct("Куртка", uuid, 45);
        List<BasketItem> listBasketItem = new ArrayList<>();
        listBasketItem.add(new BasketItem(product, 1));
        UserBasket userBasket = new UserBasket(listBasketItem);
        Map<UUID, Integer> products = new HashMap<>();
        products.put(uuid, 1);
        Optional<Product> optionalProduct = Optional.of(product);

        Mockito.when(storageService.getProductById(uuid)).thenReturn(optionalProduct);
        Mockito.when(productBasket.getProducts()).thenReturn(products);

        Assertions.assertTrue(userBasket.equals(basketService.getUserBasket()));
    }

}
