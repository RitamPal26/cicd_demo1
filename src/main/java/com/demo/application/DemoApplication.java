// File: src/main/java/com/demo/application/DemoApplication.java
@SpringBootApplication
@RestController
public class DemoApplication {

    @GetMapping("/")
    public String home() {
        return "Hello from DevOps CI/CD Demo!";
    }

    @GetMapping("/version")
    public String version() {
        return "v1.0.1-secure";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
