package com.hector.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "book")
public class Book implements Serializable {
    @Id
    private String id;
    private String tittle;
    private String synopsis;
    private Double ranking;
    private String writer;
    private List<String> categories;
}
