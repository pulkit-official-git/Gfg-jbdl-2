package com.example.batch2bookmanagementsystem.controllers;

import com.example.batch2bookmanagementsystem.dtos.CreateBookRequest;
import com.example.batch2bookmanagementsystem.models.Book;
import com.example.batch2bookmanagementsystem.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public void addBook(@Valid @RequestBody CreateBookRequest createBookRequest) throws SQLException {
        this.bookService.addBook(createBookRequest);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() throws SQLException {
        return this.bookService.getAll();
    }

    @GetMapping
    public Book getBookById(@RequestParam int id) throws SQLException {
        return this.bookService.getById(id);
    }


}
