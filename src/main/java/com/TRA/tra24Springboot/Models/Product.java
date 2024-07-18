package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "product")
public class Product extends BaseEntity {


    Integer quantity;
    String category;
    UUID sku; //This is the id for product
    @OneToOne
    ProductDetails productDetails; //This for each product it will have it own description

}
