package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void add(User user) {
        this.userRepository.save(user);

        JSONObject jsonObject = this.objectMapper.convertValue(user, JSONObject.class);
        this.kafkaTemplate.send("user-created", jsonObject.toString());
    }
}
