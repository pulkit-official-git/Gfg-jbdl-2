package com.example.batch2redisimpl.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private Double creditScore;

}
