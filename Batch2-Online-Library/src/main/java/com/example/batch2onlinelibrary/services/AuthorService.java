package com.example.batch2onlinelibrary.services;

import com.example.batch2onlinelibrary.models.Author;
import com.example.batch2onlinelibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author getOrCreate(Author author) {
        Author existingAuthor = this.authorRepository.findByEmail(author.getEmail());

        if(existingAuthor == null) {
            author = this.authorRepository.save(author);
            return author;
        }
        return existingAuthor;
    }
}
