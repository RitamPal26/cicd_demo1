// File: src/test/java/com/demo/application/DemoApplicationTests.java
package com.demo.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }
    
    @Test
    void homeEndpointShouldReturnDefaultMessage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Hello from DevOps CI/CD Demo!");
    }
    
    @Test
    void versionEndpointShouldReturnVersion() {
        String body = this.restTemplate.getForObject("/version", String.class);
        assertThat(body).contains("v1.0.0");
    }
}