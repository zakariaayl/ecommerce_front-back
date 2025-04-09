package com.example.ecommerce.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "fullname")
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public type getGender() {
        return gender;
    }

    @Column(name = "age")
    int age;

    @Column(name="pwd",length = 255)
    String password ;

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setGender(type gender) {
    this.gender = gender;
  }

  @Column(name="role",length = 30)
    String role;

    @Column(name = "address")
    String address;
    enum type{
        Male,
        Female
    }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "gender")
    type gender;
    String email;

}
