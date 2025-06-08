package com.example.batch2jpa.services;

import com.example.batch2jpa.dtos.CreateBookRequest;
import com.example.batch2jpa.models.Book;
import com.example.batch2jpa.models.Genre;
import com.example.batch2jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(CreateBookRequest createBookRequest) {
        Book book = createBookRequest.toBook();
        String email = book.getAuthorEmail();
//        Book book2 = this.bookRepository.findByAuthorEmail(email);
//        if (book2 == null) {
            this.bookRepository.save(book);
//        }
    }

    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    public Book getById(int id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public List<Book> getByGenreOrName(Genre genre, String name) {
        return this.bookRepository.findBookByGenreOrTitle(genre,name);
    }

    public void updateGenreById(Genre genre, Integer id) {
        Book book = this.bookRepository.findById(id).orElse(null);
        if (book != null) {
            this.bookRepository.updateGenreById(genre,id);
        }

    }
}
