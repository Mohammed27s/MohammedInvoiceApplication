package com.TRA.tra24Springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Supplier extends BaseEntity{

    String companyName;
    String country;

    @OneToOne
    ContactDetails contactDetails;

    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Product> productsOffered;
    Date nextDeliveryTime;

    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Product> expectedProducts;

    String complaints;
    String paymentMethods; //TODO: Enum for payment methods //Done
    String shippingMethods;
    String minimumOrderQuantity;

    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Order> orders;

}
