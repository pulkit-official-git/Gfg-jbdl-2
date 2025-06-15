package com.example.batch2onlinelibrary.repository;

import com.example.batch2onlinelibrary.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
}
