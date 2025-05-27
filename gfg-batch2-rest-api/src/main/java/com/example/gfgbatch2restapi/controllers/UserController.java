package com.example.gfgbatch2restapi.controllers;

import com.example.gfgbatch2restapi.dtos.CreateRequestDto;
import com.example.gfgbatch2restapi.dtos.CreateUserResponse;
import com.example.gfgbatch2restapi.dtos.UserResponse;
import com.example.gfgbatch2restapi.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @PostMapping("/user/create")
    public CreateUserResponse createUser(@RequestBody CreateRequestDto createRequestDto){
//        UserService userService = new UserService();
        return userService.createUser(createRequestDto);
    }

    @GetMapping("/user/fetch/{userid}")
    public UserResponse getUser(@PathVariable Integer userid){
//        UserService userService = new UserService();
        return userService.getUser(userid);
    }
}
