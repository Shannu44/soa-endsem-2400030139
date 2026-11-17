package com.endexam.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserProfileRetrival {
    public static void main(String[] args) {
        SpringApplication.run(UserProfileRetrival.class, args);
        System.out.println("UserService is working!!!.....");
    }
}
