package com.hector.library.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookCreateRequest {
    @JsonProperty
    private String tittle;
    @JsonProperty
    private String synopsis;
    @JsonProperty
    private String writer;
    @JsonProperty
    private Double ranking;
    @JsonProperty
    private List<String> categories;
}
