package com.example.ecommerce.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Access(AccessType.PROPERTY)
@Entity
@Table(name = "Orders")
public class Order {

    private int id;

    @Column(name = "status")
    private String status; // PENDING, SHIPPED, DELIVERED, CANCELLED
    @Column(name = "Date")
    private LocalDateTime date;


    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDateTime orderDate) {
        this.date = orderDate;
    }



    public String getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }
@Column(name="quantity")
    public int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "hh "+this.date;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
