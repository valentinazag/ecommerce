package com.techlab.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlab.ecommerce.exception.ProductNotFoundException;
import com.techlab.ecommerce.model.Product;
import com.techlab.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> listProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) throws ProductNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(int id, Product product) throws ProductNotFoundException {
       Product existingProduct = repository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setCategory(product.getCategory());
      return repository.save(existingProduct);
    }

    public void deleteProduct(int id) throws ProductNotFoundException {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> findByCategory(String category) {
        return repository.findByCategory(category);
    }
}