package com.example.batch2indbsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface DemoUserDetailsRepository extends JpaRepository<DemoUser,Long> {
    UserDetails findByUsername(String username);
}
