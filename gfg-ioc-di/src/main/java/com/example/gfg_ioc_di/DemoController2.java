package com.example.gfg_ioc_di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {


    Logger logger = LoggerFactory.getLogger(DemoController2.class);

    @Autowired
    private Student student;

    @GetMapping("/demo2")
    public String hello2() {
        logger.info("Inside Demo2, student - {}",student);
        this.student.setId(5);
        this.student.setName("Second");
        logger.info("Inside Demo2 after updating, student - {}",student);
        return "Hello World!";
    }
}
