package com.example.gfgbatch2restapi.services;

import com.example.gfgbatch2restapi.dtos.CreateRequestDto;
import com.example.gfgbatch2restapi.dtos.CreateUserResponse;
import com.example.gfgbatch2restapi.dtos.UserResponse;
import com.example.gfgbatch2restapi.models.User;
import com.example.gfgbatch2restapi.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public CreateUserResponse createUser(CreateRequestDto createRequestDto) {
        User user = createRequestDto.toUser();
//        UserRepository userRepository = new UserRepository();
        user = userRepository.create(user);
        return CreateUserResponse.fromUser(user);
    }

    public UserResponse getUser(Integer id) {
//        UserRepository userRepository = new UserRepository();
        User user= userRepository.get(id);
        return UserResponse.fromUser(user);
    }
}
