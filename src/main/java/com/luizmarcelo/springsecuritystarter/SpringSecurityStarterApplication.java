package com.luizmarcelo.springsecuritystarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityStarterApplication.class, args);
    }

}
