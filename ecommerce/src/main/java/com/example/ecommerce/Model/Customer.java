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
    @Column(name = "address")
    String address;
    enum type{
        Male,
        Female
    }
    @Column(name = "gender")
    type gender;


}
