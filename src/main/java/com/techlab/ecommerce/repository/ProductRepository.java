package com.techlab.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.techlab.ecommerce.model.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{
List<Product> findByNameContainingIgnoreCase(String name);
@Query("SELECT p FROM Product p WHERE LOWER(p.category.name) LIKE LOWER(CONCAT('%', :categoryName, '%'))")
List <Product> findByCategory(@Param("categoryName")String categoryName);
}