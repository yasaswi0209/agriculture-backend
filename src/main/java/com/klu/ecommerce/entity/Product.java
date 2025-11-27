package com.klu.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // OLD VARIABLES
    private String name;
    private String category;
    private double price;
    private String imagePath;

    // NEW VARIABLES
    private String description;
    private int quantity;
    private String unit;
    private double discount;
    private String brand;

    // DEFAULT CONSTRUCTOR
    public Product() {}

    // RESTORED OLD 4-ARG CONSTRUCTOR (VERY IMPORTANT)
    public Product(String name, String category, double price, String imagePath) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;

        // Provide safe defaults for new fields
        this.description = "";
        this.quantity = 0;
        this.unit = "";
        this.discount = 0.0;
        this.brand = "";
    }

    // NEW FULL CONSTRUCTOR
    public Product(String name, String category, double price, String imagePath,
                   String description, int quantity, String unit,
                   double discount, String brand) {

        this.name = name;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
        this.description = description;
        this.quantity = quantity;
        this.unit = unit;
        this.discount = discount;
        this.brand = brand;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getImagePath() { return imagePath; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public String getUnit() { return unit; }
    public double getDiscount() { return discount; }
    public String getBrand() { return brand; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setDescription(String description) { this.description = description; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setUnit(String unit) { this.unit = unit; }
    public void setDiscount(double discount) { this.discount = discount; }
    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", discount=" + discount +
                ", brand='" + brand + '\'' +
                '}';
    }
}
