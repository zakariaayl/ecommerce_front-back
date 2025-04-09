package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Customer;
import com.example.ecommerce.Model.Order;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;

@Repository

public class customerRepo {
    private final SessionFactory sessionfactory;
    private final PasswordEncoder passwordEncoder;
    public customerRepo(SessionFactory sessionfactory,PasswordEncoder passwordEncoder) {
        this.sessionfactory = sessionfactory;
        this.passwordEncoder=passwordEncoder;
    }
    public ResponseEntity<String> register(Customer cus) throws IOException{
        try(Session session =sessionfactory.openSession()){
            session.beginTransaction();
            cus.setPassword(passwordEncoder.encode(cus.getPassword()));
            session.save(cus);
            session.getTransaction().commit();
            return ResponseEntity.ok("all went good");
        }catch (Exception e){
            e.printStackTrace();
          return ResponseEntity.status(500).body("error");
        }
    }
    public Optional<Customer> findbyemail(String email){
      try(Session session=sessionfactory.openSession()){
        session.beginTransaction();
        Customer customer =session.createQuery("select u from Customer u where email=:email",Customer.class).setParameter("email",email).uniqueResult();

        session.getTransaction().commit();
        return Optional.ofNullable(customer);
      }
    }
    public  boolean login(Customer cus){
        try(Session session=sessionfactory.openSession()){
            session.beginTransaction();
            Customer customer=session.createQuery("select user from Order user where user.id= :var", Customer.class).setParameter("var",cus.getId()).uniqueResult();
            if(customer==null) return false;
            session.getTransaction().commit();
            return true;
        }
    }


}
