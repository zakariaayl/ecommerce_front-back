package com.example.ecommerce.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Access(AccessType.PROPERTY)
@Entity
@Table(name = "Orders")
public class Order {
     @Id
     @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
  @Column(name = "Date")
  private LocalDateTime date;
  @Column(name="productid")
  private Integer productid;

  public void setProductid(Integer productid) {
    this.productid = productid;
  }

  public Integer getProductid() {
    return productid;
  }

  @Column(name="price")
  private Long price;
    @Column(name = "status")
    private String status; // PENDING, SHIPPED, DELIVERED, CANCELLED



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

  public void setPrice(Long price) {
    this.price = price;
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

  public Long getPrice() {
    return price;
  }
}
