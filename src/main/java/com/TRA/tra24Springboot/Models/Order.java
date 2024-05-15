package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity {

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Product> productsOrdered;
    String categoryName;
    Date orderDate;

    @Enumerated(EnumType.STRING)
    OrderStatus status;
    String description;
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    PaymentType paymentType;
    Date dueDate;
}
