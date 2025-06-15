package com.example.batch2onlinelibrary.controller;

import com.example.batch2onlinelibrary.dtos.CreateBookRequest;
import com.example.batch2onlinelibrary.models.Book;
import com.example.batch2onlinelibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public Long createBook(@RequestBody CreateBookRequest createBookRequest) {
        return this.bookService.createBook(createBookRequest.toBook());
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return this.bookService.getBookById(id);
    }
}
