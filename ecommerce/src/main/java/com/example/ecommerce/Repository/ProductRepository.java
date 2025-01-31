package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final SessionFactory sessionfactory;
  public ProductRepository(SessionFactory sessionfactory){
      this.sessionfactory = sessionfactory;
  }
  public List<Product> getProducts(){
      List<Product> products;
      try(Session session=sessionfactory.openSession()){
          session.beginTransaction();
          products=session.createQuery("select p from Product p", Product.class).list();
          session.getTransaction().commit();
          return products;
      }catch(Exception e){
          System.out.println("yo nothing found or something went wrong");
          return null;
      }
  }
  public Product findById(Integer integer){
      try(Session session=sessionfactory.openSession()){
          session.beginTransaction();
          Product p=session.createQuery("select p from Product p where p.id= :var", Product.class).setParameter("var",integer).uniqueResult();
          session.getTransaction().commit();
          return p;
      }
  }
}
