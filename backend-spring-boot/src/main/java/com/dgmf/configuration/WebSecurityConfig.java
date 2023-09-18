package com.dgmf.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Holds all Application configurations such as "Beans" and so forth
// At the startup, Spring pickup this Class, implement and inject all
// "Beans" declared inside
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    // Bean of Type "PasswordEncoder"
    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("Stack Trace - WebSecurityConfig - " +
                "'Bean' passwordEncoder()");

        return new BCryptPasswordEncoder();
    }
}
