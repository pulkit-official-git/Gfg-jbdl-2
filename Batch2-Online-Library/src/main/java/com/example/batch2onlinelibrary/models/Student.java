package com.example.batch2onlinelibrary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {

//    Student Book. 1:M
//    Student Transaction. 1:M
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Book> issuedBooks;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

}
