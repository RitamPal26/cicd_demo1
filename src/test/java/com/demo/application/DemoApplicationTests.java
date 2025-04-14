// File: src/test/java/com/demo/application/DemoApplicationTests.java
package com.demo.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeEndpointShouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello from DevOps CI/CD Demo!"));
    }

    @Test
    void versionEndpointShouldReturnVersion() throws Exception {
        mockMvc.perform(get("/version"))
               .andExpect(status().isOk())
               .andExpect(content().string("v1.0.1-secure"));
    }
}
