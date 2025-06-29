package com.example.batch2redisimpl.dtos;

import com.example.batch2redisimpl.models.Person;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePersonRequest {

    private String name;
    private Integer age;
    private Double creditScore;


    public Person toPerson() {
        return Person
                .builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .age(age)
                .creditScore(creditScore)
                .build();
    }
}
