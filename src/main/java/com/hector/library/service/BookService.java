package com.hector.library.service;

import com.hector.library.entity.Book;
import com.hector.library.entity.BookCategory;
import com.hector.library.entity.Category;
import com.hector.library.pojo.BookCreateRequest;
import com.hector.library.repository.BookRepository;
import com.hector.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Book createBook(BookCreateRequest bookCreateRequest){
        Book book = Book.builder()
                .tittle(bookCreateRequest.getTittle())
                .synopsis(bookCreateRequest.getSynopsis())
                .categories(bookCreateRequest.getCategories())
                .writer(bookCreateRequest.getWriter())
                .ranking(bookCreateRequest.getRanking())
                .build();
        book = bookRepository.save(book);
        Book finalBook = book;
        bookCreateRequest.getCategories().forEach(category -> addBookToCategory(category,finalBook));
        return book;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    private void addBookToCategory(String categoryName, Book book ){
         Category category = categoryRepository.findByName(categoryName);
         if(ObjectUtils.isEmpty(category)){
             category = Category.builder().name(categoryName).books(new ArrayList<>()).build();
         }
         category.getBooks().add(BookCategory.builder().id(book.getId()).tittle(book.getTittle()).writer(book.getWriter()).build());
         categoryRepository.save(category);
    }

}
