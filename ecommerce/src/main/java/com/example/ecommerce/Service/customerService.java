package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Customer;
import com.example.ecommerce.Repository.customerRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class customerService {
    private final customerRepo customerrepo;

    public customerService(customerRepo customerrepo) {
        this.customerrepo = customerrepo;
    }
    public boolean login(Customer cus){
        return this.customerrepo.login(cus);
    }
    public ResponseEntity<String> register(Customer cus) throws IOException {
        if(this.customerrepo.findbyemail(cus.getEmail())==null)  return this.customerrepo.register(cus);
        return ResponseEntity.status(500).body("this email is already used by another account");
    }

}
