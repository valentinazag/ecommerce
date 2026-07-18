package com.techlab.ecommerce.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.ecommerce.exception.ProductNotFoundException;
import com.techlab.ecommerce.model.Product;
import com.techlab.ecommerce.service.ProductService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/products")
public class ProductoController {

    private final ProductService service;

    public ProductoController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(){
       List<Product> products = service.listProducts();
       return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id)
    {
        try{
            Product product = service.getProductById(id);
            return ResponseEntity.ok(product);
        }catch(ProductNotFoundException error){
        return ResponseEntity.notFound().build();
        }
       
    }

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product)
    {
        Product savedProduct = service.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @Valid @RequestBody Product product){
        try{
            Product updatedProduct = service.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        }catch(ProductNotFoundException error){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id)
    {
        try{
            service.deleteProduct(id);
            return ResponseEntity.ok().build();
        }catch(ProductNotFoundException error){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
    
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.findByCategory(category));
    }
   
}