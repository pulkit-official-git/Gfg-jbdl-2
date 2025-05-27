package com.example.gfgbatch2restapi.dtos;

import com.example.gfgbatch2restapi.models.Gender;
import com.example.gfgbatch2restapi.models.User;

public class CreateRequestDto {

    private String username;

    private String password;

    private String email;

    private Gender gender;

    private Long age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public User toUser(){
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setGender(this.gender);
        user.setAge(this.age);
        return user;
    }
}
