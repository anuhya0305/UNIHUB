package com.unihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point of our application.
 * * @SpringBootApplication tells Spring that this is the primary configuration file.
 * It automatically scans all packages underneath this directory to look for components, 
 * services, and controllers we create later.
 */
@SpringBootApplication
public class UnihubApplication {

    public static void main(String[] args) {
        // This launches the built-in Tomcat server and starts the Spring environment
        SpringApplication.run(UnihubApplication.class, args);
    }
}