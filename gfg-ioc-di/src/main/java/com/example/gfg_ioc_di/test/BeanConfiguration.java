package com.example.gfg_ioc_di.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Value("${test.testController.int}")
    Integer intTest;

    @Bean
    public Integer intTest(){
        return intTest;
    }

    @Bean
    public String stringTest(@Value("${test.testController.string}") String stringTest ){
        return stringTest;
    }

    @Bean
    public Float floatTest(@Value("${test.testController.float}") Float floatTest ){
        return floatTest;
    }
//    test.testController.string2=mango
    @Bean
    public String string2Test(@Value("${test.testController.string2}") String string2Test ){
        return string2Test;
    }
}
