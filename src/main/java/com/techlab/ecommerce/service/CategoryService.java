package com.techlab.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlab.ecommerce.exception.CategoryNotFoundException;
import com.techlab.ecommerce.model.Category;
import com.techlab.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> listCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(int id) throws CategoryNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    public Category saveCategory(Category newCategory) {
        return repository.save(newCategory);
    }

    public Category updateCategory(int id, Category category) throws CategoryNotFoundException {
        if (!repository.existsById(id)) {
            throw new CategoryNotFoundException("Category not found with id: " + id);
        }
        category.setId(id);
        return repository.save(category);
    }

    public void deleteCategory(int id) throws CategoryNotFoundException {
        if (!repository.existsById(id)) {
            throw new CategoryNotFoundException("Category not found with id: " + id);
        }
        repository.deleteById(id);
    }
}