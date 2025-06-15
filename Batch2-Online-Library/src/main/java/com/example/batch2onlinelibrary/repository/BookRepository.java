package com.example.batch2onlinelibrary.repository;

import com.example.batch2onlinelibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
