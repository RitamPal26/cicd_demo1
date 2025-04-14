// File: src/main/java/com/demo/application/DemoApplication.java
package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //For example, update the home method in DemoApplication.java to:
@GetMapping("/")
public String home() {
    return "Hello from DevOps CI/CD Demo! Welcome to our feature branch.";
}
    
    @GetMapping("/version")
    public String version() {
        return "v1.0.0";
    }
}
