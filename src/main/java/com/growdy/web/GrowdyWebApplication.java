package com.growdy.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.growdy")
public class GrowdyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowdyWebApplication.class, args);
    }
} 