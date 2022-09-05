package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SecretkeySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretkeySystemApplication.class, args);
    }

}
