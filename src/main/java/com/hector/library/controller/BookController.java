package com.hector.library.controller;

import com.hector.library.pojo.BookCreateRequest;
import com.hector.library.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@Tag(name = "Book services controller")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping()
    @Operation(summary = "This method is used to create a book")
    public ResponseEntity<?> createBook(@RequestBody BookCreateRequest bookCreateRequest) {
        return ResponseEntity.ok(bookService.createBook(bookCreateRequest));
    }

    @GetMapping
    @Operation(summary = "this method is used to get all the books")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
