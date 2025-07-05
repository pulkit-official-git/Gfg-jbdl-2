package com.example.securitybatch2test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/user/demo")
    public String user() {
        return "Hello User";
    }

    @GetMapping("/admin/demo")
    public String admin() {
        return "Hello Admin";
    }

    @GetMapping("/demo")
    public String demo() {
        return "Hello Demo";
    }


}
