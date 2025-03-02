package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface Searchable {
    @JsonIgnore
    String searchTerm();
    @JsonIgnore
    String getContent();

    default String getStringRepresentation(Searchable searchable) {
        return "имя Searchable объекта — тип Searchable-объекта";
    }

    UUID getId();

}
