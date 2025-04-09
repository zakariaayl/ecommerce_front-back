package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.Service.customerService;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class customerController {
    final private customerService customerService;
    final private AuthenticationManager authenticationManager;

    public customerController(customerService customerService,AuthenticationManager authenticationManager) {
        this.customerService = customerService;
        this.authenticationManager=authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer cus){
      try {
        Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(cus.getEmail(), cus.getPassword())
        );
        return ResponseEntity.ok("Login successful!");

      } catch (AuthenticationException e) {
        return ResponseEntity.status(401).body("Invalid email or password");
      }

    }
    @GetMapping("/login")
    public String loginN(){
        return "login";
    }
    @PostMapping("register")
    public ResponseEntity<String>  register(@RequestBody Customer cus) throws IOException {
        return this.customerService.register(cus);
    }
    @GetMapping("/errors")
    public String error(){
        return "must be a problem at the app try login later";
    }
}
