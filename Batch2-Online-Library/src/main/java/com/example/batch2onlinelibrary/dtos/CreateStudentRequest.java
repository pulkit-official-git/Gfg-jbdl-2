package com.example.batch2onlinelibrary.dtos;

import com.example.batch2onlinelibrary.models.Student;
import com.example.batch2onlinelibrary.models.StudentStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    private String name;


    private String email;

    @NotBlank
    private String mobile;


    public Student toStudent() {
        return Student.builder()
                .name(name)
                .email(email)
                .mobile(mobile)
                .status(StudentStatus.ACTIVE)
                .build();
    }
}


