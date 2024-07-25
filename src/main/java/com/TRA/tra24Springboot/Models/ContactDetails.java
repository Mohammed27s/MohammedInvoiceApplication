package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;



@EqualsAndHashCode(callSuper = true) //This is for
@Data
@Entity
@Builder
@Table(name = "contact_details")
public class ContactDetails extends BaseEntity {
  //These attributes for Contact Details


    String email;
    String phoneNumber;
    String faxNumber;
    String address;
    String postalCode;



}
