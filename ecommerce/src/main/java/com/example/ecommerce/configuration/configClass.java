package com.example.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
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
      registry.addMapping("/product/postProduct").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
      registry.addMapping("/order/postOrder").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
      registry.addMapping("/**").allowedOrigins("http://localhost:4200/").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS").allowedHeaders("*")
        .allowCredentials(true);
    }
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//mni t enabli angular 3la security 7ydha
//    http
//      .csrf(csrf -> csrf.disable())
//      .authorizeHttpRequests(auth -> auth
//        .anyRequest().permitAll()
//      );
//
//    return http.build();
//  }

}
