package com.TRA.tra24Springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Data
@Entity

public class Inventory extends BaseEntity {

    @OneToMany
    @Cascade(CascadeType.ALL)
    List<Product> products;
    String location;
    String manager;//TODO: Update once user class created //Done
    //@OneToMany
    //@Cascade(CascadeType.ALL) //If there is error delete this
    List<String> workers; //TODO: Update user class created //Done
    String supplier; //TODO: Update once supplier class created //Done
    String phoneNumber;
    String openingHours;
    String closingHours;


}
