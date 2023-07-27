package com.hector.library.service;

import com.hector.library.entity.Book;
import com.hector.library.pojo.BookCreateRequest;
import com.hector.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(BookCreateRequest bookCreateRequest){
        Book book = Book.builder()
                .tittle(bookCreateRequest.getTittle())
                .synopsis(bookCreateRequest.getSynopsis())
                .genres(bookCreateRequest.getGenres())
                .build();
        return bookRepository.save(book);
    }

}
