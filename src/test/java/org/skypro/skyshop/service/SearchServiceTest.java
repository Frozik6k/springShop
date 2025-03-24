package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.Article;
import org.skypro.skyshop.model.Product;
import org.skypro.skyshop.model.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void whenStorageServiceIsEmpty_ThenSearchReturnListSearchResultEmpty() {
        Mockito.when(storageService.getProducts()).thenReturn(new HashMap<UUID, Product>());
        Mockito.when(storageService.getArticles()).thenReturn(new HashMap<UUID, Article>());
        Assertions.assertEquals(new ArrayList<SearchResult>(), searchService.search("Книга"));
        Mockito.verify(storageService).getProducts();
        Mockito.verify(storageService).getArticles();
    }

    @Test
    void whenStorageServiceNotEmpty_ThenSearchReturnListSearchResultEmpty() {
        Map<UUID, Product> products = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        products.put(uuid, new SimpleProduct("Носки", uuid, 10));

        Mockito.when(storageService.getProducts()).thenReturn(products);
        Assertions.assertEquals(new ArrayList<SearchResult>(), searchService.search("Книга"));
        Mockito.verify(storageService).getProducts();
        Mockito.verify(storageService).getArticles();
    }

    @Test
    void whenStorageServiceNotEmpty_ThenSearchReturnListSearchResultNotEmpty() {
        Map<UUID, Product> products = new HashMap<>();
        UUID uuid = UUID.randomUUID();
        products.put(uuid, new SimpleProduct("Книга", uuid, 10));

        Mockito.when(storageService.getProducts()).thenReturn(products);
        Assertions.assertNotEquals(new ArrayList<SearchResult>(), searchService.search("Книга"));
        Mockito.verify(storageService).getProducts();
        Mockito.verify(storageService).getArticles();
    }

}
