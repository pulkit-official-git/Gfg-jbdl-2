package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestConfiguration testConfiguration;

    @Autowired
    private static TestService testService;
//    private TestRepository testRepository;

//    @Value("${test.testController.int}")
    private int intTest;
//    @Value("${test.testController.string}")
    private String stringTest;
//    @Value("${test.testController.float}")
    private Float floatTest;

//    public TestController() {
//    }

    @Autowired
    public TestController(TestService testService,@Value("${test.testController.int}") int intTest,
                          @Value("${test.testController.string}") String stringTest,
                          @Value("${test.testController.float}") Float floatTest) {
        logger.info("Inside TestController : testservice-{}", testService);
        this.testService = testService;
        this.testService.doSomething();
        this.intTest = intTest;
        this.stringTest = stringTest;
        this.floatTest = floatTest;
    }

//    @Autowired
//    public TestController(TestRepository testRepository) {
//        logger.info("Inside TestController : testrepository-{}", testRepository);
//        this.testRepository = testRepository;
////        this.testService.doSomething();
//    }

    @GetMapping("/test")
    public HashMap<String,Object> read() {
        logger.info("Inside TestController : read");
        HashMap<String,Object> map = new HashMap<>();
        map.put("intTest", intTest);
        map.put("stringTest", stringTest);
        map.put("floatTest", floatTest);
        ObjectMapper o1 = this.testConfiguration.getObjectMapper();
        ObjectMapper o2 = this.testConfiguration.getObjectMapper();
        ObjectMapper o3 = this.testConfiguration.getObjectMapper();
        return map;
    }

}
