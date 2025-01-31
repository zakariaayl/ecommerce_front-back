package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Customer;
import com.example.ecommerce.Model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;

@Repository
public class customerRepo {
    private final SessionFactory sessionfactory;
    public customerRepo(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }
    public String register(Customer cus) throws IOException{
        try(Session session =sessionfactory.openSession()){
            session.beginTransaction();
            session.save(cus);
            session.getTransaction().commit();
            return "registered succesifuly";
        }catch (Exception e){
            e.printStackTrace();
            return "something went wrong";
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
