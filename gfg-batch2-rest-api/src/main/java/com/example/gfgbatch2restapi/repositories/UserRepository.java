package com.example.gfgbatch2restapi.repositories;

import com.example.gfgbatch2restapi.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserRepository {

    Map<Integer, User> users = new HashMap<>();

    public User create(User user) {
        Integer id = new Random().nextInt(100);
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public User get(Integer id) {
        if(users.containsKey(id)) {
            return users.get(id);
        }
        return null;
    }
}
