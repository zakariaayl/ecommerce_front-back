package com.example.ecommerce.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity
@Table(schema = "Product")
public class Product {
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "status")
    String status;
    @Column(name = "quantity")
    String quantity;
    @Column(name = "imgurl")
    String imgUrl;

    public String getDescription() {
        return description;
    }

    @Column(name="description")
    String description;
    @Column(name = "price")
    private int totalPrice;
    @Column(name="category")
    private String category;

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getPrice() {
        return totalPrice;
    }

    @Override
    public String toString(){
        return this.imgUrl+","+this.name+","+this.quantity;
    }
}
