package com.example.gfg_ioc_di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private Student student;



    Logger logger = LoggerFactory.getLogger(DemoController.class);
    DemoController(Student student){
        logger.info("Inside DemoController: this = {}, student={} ",this, this.student);
    }

    @GetMapping("/demo")
    public String hello() {
//        DemoController demoController = new DemoController();
//        Student student = new Student();
        logger.info("Inside Demo, student - {}",student);
//        this.student.setId(1);
//        this.student.setName("First");
//        logger.info("Inside Demo after updating, student - {}",student);
        return "Hello World!";
    }
}
