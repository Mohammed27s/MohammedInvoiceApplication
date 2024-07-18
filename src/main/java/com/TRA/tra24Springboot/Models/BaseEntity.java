package com.TRA.tra24Springboot.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@MappedSuperclass
@Builder
@Table(name = "Base")
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Date createdDate;
    Date updatedDate;
    Boolean isActive;

}
