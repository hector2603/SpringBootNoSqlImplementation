package com.hector.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCategory {

    private String id;
    private String tittle;
    private String writer;

}
