package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Customer;
import com.example.ecommerce.Repository.customerRepo;
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
    public String register(Customer cus) throws IOException {
        return this.customerrepo.register(cus);
    }

}
