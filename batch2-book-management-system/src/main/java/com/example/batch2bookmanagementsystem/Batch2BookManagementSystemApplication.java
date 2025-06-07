package com.example.batch2bookmanagementsystem;

import com.example.batch2bookmanagementsystem.models.Book;
import com.example.batch2bookmanagementsystem.models.Genre;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Batch2BookManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(Batch2BookManagementSystemApplication.class, args);

        Book book = new Book();
        book.setTitle("Book Title");
        System.out.println(book.getTitle());
        Book book2 = new Book(1,"Harry Potter","J K Rowling","jk@gmail.com", Genre.FICTIONAL,new Date(),new Date());
        System.out.println(book2);

        Book book3 = new Book(1,null,"J K Rowling",null,null,null,null);

//        Book book4 = new Book().setId(1).setGenre(Genre.HISTORY);
//        book4.setTitle("Harry Potter").setId(1).setGenre(Genre.FICTIONAL);
        Book.BookBuilder bookBuilder = Book.builder()
                .id(1)
                .title("Into to Maths")
                .genre(Genre.MATHS);
//                .build();
//        System.out.println(book5);


        Book book5 =bookBuilder.author("Mathematician").build();
        System.out.println(book5);
    }

}
