package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Customer;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.Service.customerService;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class customerController {
    final private customerService customerService;

    public customerController(customerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Customer cus){
        return this.customerService.login(cus);
    }
    @GetMapping("/login")
    public String loginN(){
        return "login";
    }
    @PostMapping("register")
    public String  register(@RequestBody Customer cus) throws IOException {
        return this.customerService.register(cus);
    }
    @GetMapping("/errors")
    public String error(){
        return "must be a problem at the app try login later";
    }
}
