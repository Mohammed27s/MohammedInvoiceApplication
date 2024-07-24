package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Date createdDate;
    Date updatedDate;
    Boolean isActive; //There is an issue with the Boolean type

}
