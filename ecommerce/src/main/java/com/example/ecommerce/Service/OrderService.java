package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Order;
import com.example.ecommerce.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepo orderRepository;

    @Autowired
    public OrderService(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Optional<Order> getAllOrder(int id) {
        return this.orderRepository.findById(id);
    }
    public Order saveAndFlush(Order entity){
         this.orderRepository.saveAndFlush(entity);
        return entity;
    }
}
