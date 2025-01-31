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
              p.setName("picture");
              p.setStatus("good");
              p.setQuantity("56");
              p.setImgUrl("assets/images/R.jpg");
              p.setDescription("kay3ref yjri ,ykkhdem lil o nhar w9tma bghiti ,bla matwklo mawalo ydber rasso");
              session.save(p);
            session.getTransaction().commit();
        }
    }
}
