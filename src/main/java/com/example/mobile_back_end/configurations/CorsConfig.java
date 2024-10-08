package com.example.mobile_back_end.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:4200", // Permitir requisições do Angular localhost
                        "http://localhost:8100"  // Permitir requisições do aplicativo
                )
                .allowedMethods("GET", "POST", "PUT", "PATCH","DELETE", "OPTIONS")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
                .maxAge(3600); // Tempo de validade do pre-flight request (1 hora)
    }
}
