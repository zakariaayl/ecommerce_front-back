package com.example.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@Profile("dev")
public class configClass implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/order/getOrders").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
        registry.addMapping("/product/getProducts").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
        registry.addMapping("/product/getProduct/{id}").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
      registry.addMapping("/product/search/{str}").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
    }
}
