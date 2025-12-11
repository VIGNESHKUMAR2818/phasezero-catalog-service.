package com.org.phasezero_catalog_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "products",
    uniqueConstraints = @UniqueConstraint(columnNames = "partNumber")
)

public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // technical primary key

    @NotBlank(message = "partNumber is required")
    @Column(nullable = false, unique = true)
    private String partNumber;

    @NotBlank(message = "partName is required")
    @Column(nullable = false)
    private String partName;   

    @NotBlank(message = "category is required")
    @Column(nullable = false)
    private String category;

    @Min(value = 0, message = "price must be non-negative")
    @Column(nullable = false)
    private double price;

    @Min(value = 0, message = "stock must be non-negative")
    @Column(nullable = false)
    private int stock;

    public Product() {
    }

   
    @PrePersist
    @PreUpdate
    public void normalize() {
        if (partName != null) {
            partName = partName.toLowerCase();
        }
        if (category != null) {
            category = category.toLowerCase();
        }
    }


    public Long getId() {
        return id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
