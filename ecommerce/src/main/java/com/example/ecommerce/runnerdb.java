package com.example.ecommerce;

import com.example.ecommerce.Model.Order;
import com.example.ecommerce.Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class runnerdb {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Order order=new Order();
        Product p=new Product();
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
              p.setName("phone");
              p.setStatus("good");
              p.setPrice(75);
              p.setQuantity(56);
              p.setCategory("art");
              p.setImgUrl("assets/images/phones.jpg");
              p.setDescription("A suit is a timeless ensemble that blends elegance and sophistication. It typically includes a matching jacket and trousers.");
//          order.setDate(LocalDateTime.now());
//          order.setPrice(50L);
//          order.setQuantity(10);
//          order.setStatus("iwa");

              session.save(p);
            session.getTransaction().commit();
        }
    }
}
