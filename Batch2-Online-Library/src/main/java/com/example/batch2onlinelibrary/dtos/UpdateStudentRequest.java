package com.example.batch2onlinelibrary.dtos;

import com.example.batch2onlinelibrary.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentRequest {

    private String name;

    private String email;

    private String mobile;


    public Student toStudent() {
        return Student.builder()
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}



