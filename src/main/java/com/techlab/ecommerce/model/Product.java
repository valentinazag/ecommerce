package com.techlab.ecommerce.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "The name of the product can't be empty")
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @PositiveOrZero(message = "The stock can't be negative")
    @Column(name = "stock", nullable = false)
    private int stock;
    @Positive(message = "The price must be higher than zero")
    @Column(name = "price", nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "The category can't be null")
    private Category category;


    public Product(String name, double price, int stock, Category category) {
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.category = category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

     public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}