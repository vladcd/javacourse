package com.example.modules.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.modules")
public class ModulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModulesApplication.class, args);
    }

}
