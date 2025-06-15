package com.example.batch2onlinelibrary.services;

import com.example.batch2onlinelibrary.models.Author;
import com.example.batch2onlinelibrary.models.Book;
import com.example.batch2onlinelibrary.repository.AuthorRepository;
import com.example.batch2onlinelibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public Long createBook(Book book) {

        Author author = book.getAuthor();

        author = this.authorService.getOrCreate(author);
        book.setAuthor(author);
        return this.bookRepository.save(book).getId();

    }

    public Book getBookById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    public Book addOrUpdate(Book book) {
//        Book existingBook = this.getBookById(book.getId());
//        if (existingBook == null) {
            return bookRepository.save(book);
//        }
    }
}
