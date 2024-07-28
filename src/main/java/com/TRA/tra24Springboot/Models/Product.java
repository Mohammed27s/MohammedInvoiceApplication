package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private String category;
    private UUID sku;

    @OneToOne
    private ProductDetails productDetails;

    // No-argument constructor is required by JPA
    public Product() {}

    // Constructor with arguments (optional, usually for testing purposes)
    public Product(Integer id, Integer quantity, String category, UUID sku, ProductDetails productDetails) {
        this.id = id;
        this.quantity = quantity;
        this.category = category;
        this.sku = sku;
        this.productDetails = productDetails;
    }
}
