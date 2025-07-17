package com.example.batch2indbsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfig {

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public AuthenticationManager authenticationManager(DemoUserDetailsService demoUserDetailsService,
                                                       PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(demoUserDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/user/signup").permitAll()
                        .requestMatchers("/user/**").hasAuthority("USER")
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/demo").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


}
