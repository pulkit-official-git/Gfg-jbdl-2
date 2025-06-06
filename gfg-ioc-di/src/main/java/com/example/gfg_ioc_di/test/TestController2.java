package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @Autowired
    private TestConfiguration testConfiguration;

//    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/test2dummy")
    public void func(){

        ObjectMapper o1 = this.testConfiguration.getObjectMapper();
        ObjectMapper o2 = this.testConfiguration.getObjectMapper();
        ObjectMapper o3 = this.testConfiguration.getObjectMapper();

    }
}
