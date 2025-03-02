package org.skypro.skyshop.service;


import org.skypro.skyshop.model.Article;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService){
        this.storageService = storageService;
    }

    public Collection<Searchable> getSearchables(){

        Map<UUID, Searchable> result = new HashMap<>(storageService.getArticles());
        result.putAll(storageService.getProducts());
        return result.values();
    }

    public Collection<SearchResult> search(String textSearch){
        return getSearchables().stream().filter(t -> t.searchTerm().contains(textSearch)).map(SearchResult::fromSearchable).collect(Collectors.toList());
    }
}
