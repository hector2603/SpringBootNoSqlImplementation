package com.hector.library.service;


import com.hector.library.entity.Book;
import com.hector.library.entity.BookCategory;
import com.hector.library.entity.Category;
import com.hector.library.repository.BookRepository;
import com.hector.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    public Category findCategory(String category) {
        return categoryRepository.findByName(category);
    }

    public Category findCategoryOtherWay(String category) {
        List<Book> books = bookRepository.findAllByCategoriesIn(category);
        return Category.builder().name(category).books(books.stream().map(b -> BookCategory.builder().id(b.getId()).tittle(b.getTittle()).build()).collect(Collectors.toList())).build();
    }
}
