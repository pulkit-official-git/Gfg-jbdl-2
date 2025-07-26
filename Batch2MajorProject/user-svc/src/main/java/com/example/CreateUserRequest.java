package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    private String name;

    private String email;

    private String mobile;

    public User toUser(){
        return User.builder()
                .name(name)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
