package com.example.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class securityClass {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .cors(cors->cors.configurationSource(corsConfigurationSource()))
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/product/*").authenticated()
        .requestMatchers("/order/postOrder").authenticated()
        .requestMatchers("/user/*").permitAll()
        .anyRequest().authenticated()
      )
      .formLogin(Customizer.withDefaults())
      .httpBasic(Customizer.withDefaults())
    .csrf(cr->cr.disable())//kat7yde tokenisation
      .build();
  }
//hadi ila biti t stori userinfo f application memory (securityContext)
//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails user = User.withUsername("zakaria").password(passwordEncoder().encode("zakaria")).roles("ADMIN").build();
//    UserDetails user2 = User.withUsername("user").password(passwordEncoder().encode("user")).authorities("user").build();
//    return new InMemoryUserDetailsManager(user2, user);
//  }


  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:4200"));
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(List.of("Authorization", "Content-Type","X-CSRF-TOKEN"));
    configuration.setAllowCredentials(true);
    configuration.setExposedHeaders(List.of("X-CSRF-TOKEN"));
//    configuration.setAllowedHeaders(List.of("Access-Control-Allow-Headers"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
  @Bean
  public PasswordEncoder passwordEncoder(){
     return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }
//Default handling using JdbcUserDetailsManager
//  create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
//  create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
//  create unique index ix_auth_username on authorities (username,authority);
  //jbthom mn users.ddl bach n ennabli users handling in database check JdbcDaoImpl par defaut homa li kaytcheki f database dialk
//@Bean
//public UserDetailsService userDetailsService(DataSource dataSource) {
//  return new JdbcUserDetailsManager(dataSource);//hadi default,use your custtimezed
//  //datasource is created from application property, in case od login it checks the table users for that user
//}
  //ila mabghitich default chof myownUserDetailsService

}
