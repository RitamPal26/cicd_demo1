// File: src/test/java/com/demo/application/DemoApplicationTests.java
package com.demo.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homeEndpointShouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello from DevOps CI/CD Demo! Welcome to our secure application."))
            .andExpect(header().exists("Content-Security-Policy"))
            .andExpect(header().exists("X-Content-Type-Options"))
            .andExpect(header().exists("X-Frame-Options"));
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void versionEndpointShouldReturnVersion() throws Exception {
        mockMvc.perform(get("/version"))
            .andExpect(status().isOk())
            .andExpect(content().string("v1.0.1-secure"));
    }
}
