package com.example.batch2bookmanagementsystem.dtos;

import com.example.batch2bookmanagementsystem.models.Book;
import com.example.batch2bookmanagementsystem.models.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

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
                .createdOn(new Date())
                .updatedOn(new Date())
                .build();
    }
}
