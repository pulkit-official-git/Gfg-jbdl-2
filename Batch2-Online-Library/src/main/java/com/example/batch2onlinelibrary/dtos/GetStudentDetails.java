package com.example.batch2onlinelibrary.dtos;

import com.example.batch2onlinelibrary.models.Student;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStudentDetails {

    private Student student;
}
