package com.example.batch2redisimpl.controllers;

import com.example.batch2redisimpl.dtos.CreatePersonRequest;
import com.example.batch2redisimpl.models.Person;
import com.example.batch2redisimpl.services.ListValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListValueController {

    @Autowired
    private ListValueService listValueService;

    @PostMapping("/lpush")
    public Long lpush(@RequestBody CreatePersonRequest createPersonRequest) {
        return this.listValueService.lpush(createPersonRequest.toPerson());
    }

    @PostMapping("/rpush")
    public Long rpush(@RequestBody CreatePersonRequest createPersonRequest) {
        return this.listValueService.rpush(createPersonRequest.toPerson());
    }

    @PostMapping("/lpop")
    public List<Person> lpop(@RequestParam(value = "count",required = false,defaultValue = "1") Integer count) {
        return this.listValueService.lpop(count);
    }

    @PostMapping("/rpop")
    public List<Person> rpop(@RequestParam(value = "count",required = false,defaultValue = "1") Integer count) {
        return this.listValueService.rpop(count);
    }

    @GetMapping("/lrange")
    public List<Person> lrange(@RequestParam(value = "start",required = false,defaultValue = "0") Integer start,
                               @RequestParam(value = "end", required = false,defaultValue = "-1")  Integer end) {
        return this.listValueService.lrange(start,end);
    }




}
