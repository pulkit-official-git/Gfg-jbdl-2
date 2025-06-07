package com.example.batch2bookmanagementsystem.services;

import com.example.batch2bookmanagementsystem.dtos.CreateBookRequest;
import com.example.batch2bookmanagementsystem.models.Book;
import com.example.batch2bookmanagementsystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(CreateBookRequest createBookRequest) throws SQLException {
        Book book = createBookRequest.toBook();
        this.bookRepository.addBook(book);
    }

    public List<Book> getAll() throws SQLException {
        return this.bookRepository.getAll();
    }

    public Book getById(int id) throws SQLException {
        return this.bookRepository.getById(id);
    }
}
