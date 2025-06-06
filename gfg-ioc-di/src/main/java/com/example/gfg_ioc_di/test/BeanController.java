package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class BeanController {

    private Integer intT;
    private String stringT;
    private Float floatTest;
    private String string2Test;

//    @Autowired
    public BeanController(Integer intT,
                           @Qualifier("stringTest") String stringT,
                          Float floatTest){
        this.intT = intT;
        this.stringT = stringT;
        this.floatTest = floatTest;
    }

    @GetMapping("/bean")
    public HashMap<String,Object> read() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("intTest", intT);
        map.put("stringTest", stringT);
        map.put("floatTest", floatTest);
        return map;
    }
}
