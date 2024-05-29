package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Contacts")
public class ContactDetails extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    String email;
    String phoneNumber;
    String faxNumber;
    String address;
    String postalCode;

}
