package com.example.batch2redisimpl.controllers;

import com.example.batch2redisimpl.dtos.CreatePersonRequest;
import com.example.batch2redisimpl.models.Person;
import com.example.batch2redisimpl.services.HashValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hash")
public class HashFieldValueController {

    @Autowired
    private HashValueService hashValueService;

    @PostMapping("/create")
    public Person create(@RequestBody CreatePersonRequest  createPersonRequest) {
        return this.hashValueService.create(createPersonRequest.toPerson());
    }

    @GetMapping("/getAll")
    public Person getAll(@RequestParam String id) {
        return this.hashValueService.getAll(id);
    }

    @GetMapping("/field")
    public Object getFieldValue(@RequestParam String id,
                           @RequestParam String field) {
        return this.hashValueService.getFieldValue(id,field);
    }

//    @DeleteMapping("/del")
//    public void delete(@RequestParam String id,
//                       @RequestParam String field) {
//        this.hashValueService.delete(id,field);
//    }
}
