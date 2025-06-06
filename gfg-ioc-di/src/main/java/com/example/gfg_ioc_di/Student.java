package com.example.gfg_ioc_di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {

    Logger logger = LoggerFactory.getLogger(Student.class);

    private int id;
    private String name;

    public Student() {
        logger.info("Inside Default Constructor");
        logger.info("Inside Student class - {}",this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
//    public Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//        logger.info("Inside Paramaeterised Constructor");
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
