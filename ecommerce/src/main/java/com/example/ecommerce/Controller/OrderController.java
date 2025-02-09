package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Order;
import com.example.ecommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController( OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/postOrder")
    public ResponseEntity<String> postOrder(@RequestBody Order order){
      System.out.println( "mzyan "+order.quantity+" "+order.getId()+" "+order.getStatus()+" price "+order.getPrice());
      order.setDate(LocalDateTime.now());

      orderService.saveOrder(order);
      System.out.println("dezte mn hhna");
      return ResponseEntity.ok("kolchi howa hadak");
    }
    @GetMapping("/getOrders")
    public List<Order> findALL(){
        return orderService.getAllOrders();
    }
    @GetMapping("/getOrder/{id}")
    public Optional<Order> findspecificOrder(@PathVariable int id) {
        return orderService.getAllOrder(id);
    }
        @GetMapping("/test")
    public String p(){
        return "hh";
    }
    @PostMapping("/save")
    public String saveOrder(@RequestBody Order o){
        this.orderService.saveAndFlush(o);
        return "  ";
    }
}
