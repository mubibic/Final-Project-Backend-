package com.example.agcbiohardwareinventorysystembackend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // or specify a more specific path
                .allowedOrigins("http://localhost:8080") // replace with your frontend's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}

