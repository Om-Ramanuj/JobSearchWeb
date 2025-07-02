package com.Project.JOB.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:3000",        // React dev server
                        "http://127.0.0.1:5500",        // Local HTML testing
                        "file://",                      // Direct HTML file access
                        "http://localhost:8080",        // Local backend
                        "https://your-frontend.onrender.com" // Replace with actual deployed frontend URL
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false); // If using cookies, set this to true
    }
}
