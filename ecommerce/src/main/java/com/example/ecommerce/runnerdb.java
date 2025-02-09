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
        Order user=new Order();
        Product p=new Product();
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
//              p.setName("");
//              p.setStatus("good");
//              p.setPrice(50);
//              p.setQuantity(56);
//              p.setCategory("tec");
//              p.setImgUrl("assets/images/R.jpg");
//              p.setDescription("wa vchri o hnina");
          user.setDate(LocalDateTime.now());
          user.setPrice(50L);
          user.setQuantity(10);
          user.setStatus("iwa");

              session.save(p);
            session.getTransaction().commit();
        }
    }
}
