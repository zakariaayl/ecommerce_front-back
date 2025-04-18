package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Order;
import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
   private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/postProduct")
    public ResponseEntity<String> PostProducts(@RequestBody Product product){
        System.out.println("post request sent succesifuly "+product);
        return ResponseEntity.ok("good");
    }
    @GetMapping("/getProducts")
    public List<Product> GetProducts(){
        return this.productService.getProducts();
    }
    @GetMapping("/getProduct/{id}")
    public Product GetProducts(@PathVariable int id){
        return this.productService.findProductById(id);
    }
  @GetMapping("/search/{str}")
  public List<Product> GetProduct(@PathVariable String str){
    return this.productService.findProductByName(str);
  }

}
