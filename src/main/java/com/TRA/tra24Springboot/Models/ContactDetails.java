package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@Table(name = "ContactDetails")
public class ContactDetails extends BaseEntity {
  //These attributes for Contact Details


    String email;
    String phoneNumber;
    String faxNumber;
    String address;
    String postalCode;



}
