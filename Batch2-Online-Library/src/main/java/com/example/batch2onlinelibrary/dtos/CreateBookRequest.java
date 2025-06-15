package com.example.batch2onlinelibrary.dtos;

import com.example.batch2onlinelibrary.models.Author;
import com.example.batch2onlinelibrary.models.Book;
import com.example.batch2onlinelibrary.models.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    private String name;

    private Genre genre;

    private String authorName;

    private String email;

    public Book toBook() {
        return Book.builder()
                .name(name)
                .genre(genre)
                .author(Author.builder()
                        .name(authorName)
                        .email(email)
                        .build())
                .build();
    }

}
