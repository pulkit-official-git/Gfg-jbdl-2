package com.example.batch2jpa.dtos;

import com.example.batch2jpa.models.Book;
import com.example.batch2jpa.models.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {
    @NotBlank
    private String title;

    @NotBlank
    @Length(min = 5, max = 100)
    private String author;

    //    @Min()
    private String authorEmail;

    @NotNull
    private Genre genre;

    public Book toBook(){
        return Book.builder()
                .title(title)
                .author(author)
                .authorEmail(authorEmail)
                .genre(genre)
                .build();
    }
}
