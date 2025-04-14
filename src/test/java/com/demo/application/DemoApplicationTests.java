// File: src/test/java/com/demo/application/DemoApplicationTests.java
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
