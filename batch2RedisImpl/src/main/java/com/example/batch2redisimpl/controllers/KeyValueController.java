package com.example.batch2redisimpl.controllers;

import com.example.batch2redisimpl.dtos.CreatePersonRequest;
import com.example.batch2redisimpl.models.Person;
import com.example.batch2redisimpl.services.KeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/key")
public class KeyValueController {

    @Autowired
    private KeyValueService keyValueService;

    @PostMapping("/create")
    public Person create(@RequestBody CreatePersonRequest createPersonRequest) {
        return this.keyValueService.createPerson(createPersonRequest.toPerson());
    }

    @GetMapping("/get")
    public Person get(@RequestParam String id) {
        return this.keyValueService.getPerson(id);
    }


}
