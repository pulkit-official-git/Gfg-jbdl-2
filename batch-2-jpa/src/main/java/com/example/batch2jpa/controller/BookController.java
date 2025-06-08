package com.example.batch2jpa.controller;

import com.example.batch2jpa.dtos.CreateBookRequest;
import com.example.batch2jpa.models.Book;
import com.example.batch2jpa.models.Genre;
import com.example.batch2jpa.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public void addBook(@Valid @RequestBody CreateBookRequest createBookRequest){
        this.bookService.addBook(createBookRequest);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return this.bookService.getAll();
    }

    @GetMapping
    public Book getBookById(@RequestParam int id) {
        return this.bookService.getById(id);
    }

    @GetMapping("/genre/{genre}/name/{name}")
    public List<Book> getBookByGenreOrName(@PathVariable("genre") Genre genre, @PathVariable("name") String name) {
        return this.bookService.getByGenreOrName(genre,name);
    }

    @PatchMapping("/genre/{genre}/id/{id}")
    public void updateGenreById(@PathVariable("genre") Genre genre, @PathVariable("id") Integer id) {
        this.bookService.updateGenreById(genre,id);
    }


}
