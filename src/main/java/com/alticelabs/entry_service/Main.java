package com.alticelabs.entry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.alticelabs.entry_service",
                "com.alticelabs.uservice.models",
        })
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
