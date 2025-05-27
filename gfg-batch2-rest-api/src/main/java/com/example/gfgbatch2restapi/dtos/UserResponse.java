package com.example.gfgbatch2restapi.dtos;

import com.example.gfgbatch2restapi.models.Gender;
import com.example.gfgbatch2restapi.models.User;

public class UserResponse {

    private String username;

    private String email;

    private Gender gender;

    private Long age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public static UserResponse fromUser(User user) {
        if(user == null) {
            return null;
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setGender(user.getGender());
        userResponse.setAge(user.getAge());
        return userResponse;
    }
}
