package com.example.securitybatch2test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfig {

    @Bean
    public InMemoryUserDetailsManager configureAuthentication() {

        UserDetails u1 = User.builder()
                .username("posty")
                .password(passwordEncoder().encode("posty@123"))
                .authorities("ADMIN")
                .build();

        UserDetails u2 = User.builder()
                .username("fred")
                .password(passwordEncoder().encode("fred@123"))
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(u1, u2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/user/**").hasAuthority("USER")
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();

    }
}
