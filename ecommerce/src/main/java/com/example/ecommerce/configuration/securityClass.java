package com.example.ecommerce.configuration;

import jakarta.persistence.Column;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class securityClass {
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http.authorizeHttpRequests((request)->request.anyRequest().authenticated()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults())
      .formLogin(Customizer.withDefaults())
      .httpBasic(Customizer.withDefaults()).build();

  }
  @Bean
  public UserDetailsService userDetailsService(){
    UserDetails user=User.withUsername("zakaria").password("{noop}zakaria").authorities("admin").build();//admin z3ma {noop} zayda bach maytencodach l password l base64
    UserDetails user2=User.withUsername("user").password("{noop}user").authorities("user").build();
    return new InMemoryUserDetailsManager(user2, user);
  }
}
