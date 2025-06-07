package com.example.batch2bookmanagementsystem.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Book {


//    @NotBlank
    private int id;

    @NotBlank
    private String title;

//    @NotBlank
//    @Min(5)
//    @Max(50)
    private String author;

    private String authorEmail;

//    @NotBlank
    private Genre genre;

    private Date createdOn;
    private Date updatedOn;

}
