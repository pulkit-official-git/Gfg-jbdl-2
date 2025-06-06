package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("prototype")
public class TestConfiguration {

    Logger logger = LoggerFactory.getLogger(TestConfiguration.class);

    private ObjectMapper objectMapper;

    public TestConfiguration() {
//        objectMapper = new ObjectMapper();
        logger.info("TestConfiguration initialized id-{}, objectMapper-{}",this,this.objectMapper);
    }

    @Bean
    @Scope("prototype")
    public ObjectMapper getObjectMapper() {
        ObjectMapper mapper= new ObjectMapper();
        logger.info("Inside ObjectMapper: mapper = {}",mapper);
        return mapper;

    }
}
