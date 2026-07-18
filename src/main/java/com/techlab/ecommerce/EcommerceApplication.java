package com.techlab.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.techlab.ecommerce.model.Category;
import com.techlab.ecommerce.model.Product;
import com.techlab.ecommerce.service.CategoryService;
import com.techlab.ecommerce.service.ProductService;

@SpringBootApplication
public class EcommerceApplication {
    public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
@Bean
    CommandLineRunner cargarDatos(ProductService productService, CategoryService categoryService) {
	return args ->{
		if (categoryService.listCategories().isEmpty()) {
				Category food = categoryService.saveCategory(new Category("Food", "Food products"));
				Category drinks = categoryService.saveCategory(new Category("Drinks", "Drink products"));
				productService.saveProduct(new Product("Pastafrola", 3200, 50, food));
							productService.saveProduct(new Product("Jugo", 1000, 120, drinks));
			};
	};
}
}