package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class SearchResult {

    final private UUID id;
    final public String name;

    final public String content;

    public SearchResult(UUID id, String name, String content){
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public static SearchResult fromSearchable(Searchable searchable){
        return new SearchResult(UUID.randomUUID(), searchable.searchTerm(), searchable.getContent());
    }

}
