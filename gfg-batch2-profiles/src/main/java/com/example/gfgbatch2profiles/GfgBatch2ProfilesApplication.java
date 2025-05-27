package com.example.gfgbatch2profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GfgBatch2ProfilesApplication implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${library.books.days}")
    private int booksDays;

    Logger logger = LoggerFactory.getLogger(GfgBatch2ProfilesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GfgBatch2ProfilesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
        logger.info("Hello World");
        logger.info("Hello World dburl : {} days : {}",dbUrl,booksDays);
    }
}
