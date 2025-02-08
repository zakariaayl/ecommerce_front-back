package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Order;
import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
 final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return this.productRepository.getProducts();
    }
  public Product findProductById(Integer integer){
    return this.productRepository.findById(integer);
  }
  public List<Product> findProductByName(String name){
    return this.productRepository.findByName(name);
  }


}
