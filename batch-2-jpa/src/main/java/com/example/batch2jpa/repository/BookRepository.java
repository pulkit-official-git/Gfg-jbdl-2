package com.example.batch2jpa.repository;

import com.example.batch2jpa.models.Book;
import com.example.batch2jpa.models.Genre;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findBookByGenreOrTitle(Genre genre, String name);


    @Transactional
    @Modifying
    @Query("update Book b set b.genre = ?1 where b.id = ?2")
    void updateGenreById(Genre genre, Integer id);

    Book findByAuthorEmail(String email);

//    @Query("select b from Book b where b.id = ?1")
//    Book getBookById(int id);


//    @Query(value = "select * from my_table where id = ?1",nativeQuery = true)   //native
//    Book getBookById(int id);


//    @Query("select b from Book b where b.id = :id")
//    Book getBookById(int id);

//    @Query("select b from Book b")
//    List<Book> getAll();
//
//    @Query(value = "select * from my_table",nativeQuery = true)
//    List<Book> getAll();
}
