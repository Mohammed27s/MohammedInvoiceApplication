package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Contacts")
public class ContactDetails extends BaseEntity {
  //These attributes for Contact Details


    String email;
    String phoneNumber;
    String faxNumber;
    String address;
    String postalCode;

}
