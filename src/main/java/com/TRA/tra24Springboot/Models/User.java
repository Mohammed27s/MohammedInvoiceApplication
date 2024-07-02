package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class User extends BaseEntity {

    String name;
    @Enumerated(EnumType.STRING)
    UserTypes userType;

    @OneToOne
    ContactDetails contactDetails;

    AccessPrivileges accessPrivileges; //This Enum has crated



}
