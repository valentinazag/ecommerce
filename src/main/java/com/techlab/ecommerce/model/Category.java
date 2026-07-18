package com.techlab.ecommerce.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    @NotBlank(message = "The name of the category can't be empty")
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @NotBlank(message = "The description of the product can't be empty")
    @Column(name = "description", nullable = false, length = 250)
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String nombre) { this.name = nombre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | " + description;
    }
}