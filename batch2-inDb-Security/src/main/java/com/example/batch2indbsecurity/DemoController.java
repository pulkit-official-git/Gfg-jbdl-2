package com.example.batch2indbsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

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

    @PostMapping("/user/signup")
    public void createUser(@RequestParam String username, @RequestParam String password) {

        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(password)
                .authorities("USER")
                .build();

        this.demoUserDetailsService.create(demoUser);

    }

    @PostMapping("/admin/signup")
    public void createAdmin(@RequestParam String username, @RequestParam String password) {

        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(password)
                .authorities("ADMIN")
                .build();

        this.demoUserDetailsService.create(demoUser);

    }
}
