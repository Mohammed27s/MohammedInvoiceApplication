package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {


    @Query("SELECT su from Supplier su WHERE su.companyName =:companyName")
    Supplier getBySupplierName(@Param("companyName") String companyName);

    @Query("SELECT px from Supplier px WHERE px.productsOffered =:pOffer")
    List<Supplier> getSupplierByProductOffer(@Param("pOffer") String productsOffered);


}
