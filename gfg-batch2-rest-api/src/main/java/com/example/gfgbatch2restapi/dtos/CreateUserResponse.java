package com.example.gfgbatch2restapi.dtos;

import com.example.gfgbatch2restapi.models.User;

public class CreateUserResponse {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static CreateUserResponse fromUser(User user) {
        if(user == null) {
            return null;
        }
        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setId(user.getId());
        return createUserResponse;
    }
}
