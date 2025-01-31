package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepoInt extends JpaRepository<Order,Integer> {

}
