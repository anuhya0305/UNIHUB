package com.unihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnihubApplication {

    public static void main(String[] args) {
        // This launches the built-in Tomcat server and starts the Spring environment
        SpringApplication.run(UnihubApplication.class, args);
    }
}