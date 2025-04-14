// File: src/main/java/com/demo/application/DemoApplication.java
package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import java.util.UUID;

@SpringBootApplication
@RestController
@EnableMethodSecurity  // Enable method-level security annotations
public class DemoApplication {

    private final String securityVersion = "1.0.1-secure";
    private final String requestIdHeader = "X-Request-ID";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Secured endpoints with proper security headers
    @GetMapping("/")
    public ResponseEntity<String> home() {
        // Generate a unique request ID for tracking
        String requestId = UUID.randomUUID().toString();
        
        // Return response with security headers
        return ResponseEntity.ok()
            .header("Content-Security-Policy", "default-src 'self'")
            .header("X-Content-Type-Options", "nosniff")
            .header("X-Frame-Options", "DENY")
            .header(HttpHeaders.X_CONTENT_TYPE_OPTIONS, "nosniff")
            .header(HttpHeaders.X_FRAME_OPTIONS, "DENY")
            .header(requestIdHeader, requestId)
            .body("Hello from DevOps CI/CD Demo! Welcome to our secure application.");
    }
    
    // Version information now requires authorization
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok()
            .header(HttpHeaders.CACHE_CONTROL, "no-store")
            .header(HttpHeaders.PRAGMA, "no-cache")
            .body("v" + securityVersion);
    }
    
    // Add request logging for security auditing
    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(10000);
        return loggingFilter;
    }
}
