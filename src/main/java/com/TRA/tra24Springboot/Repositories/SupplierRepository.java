package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Query("SELECT su FROM Supplier su WHERE su.companyName = :companyName") //This query for getting Supplier companyName from Database
    Supplier getBySupplierName(@Param("companyName") String companyName);

    @Query("SELECT s FROM Supplier s JOIN s.productsOffered p WHERE p IN :pOffer") //This query for getting Supplier productsOffered from Database
    List<Supplier> getSupplierByProductOffer(@Param("pOffer") List<Product> productsOffered);

    @Query("SELECT sc FROM Supplier sc WHERE sc.country = :con") //This query for getting Supplier country from Database
    Supplier getBySupplierCountry(@Param("con") String country);

    @Query("SELECT sp FROM Supplier sp WHERE sp.shippingMethods = :shm") //This query for getting Supplier shippingMethods from Database
    Supplier getBySupplierShippingMethods(@Param("shm") String shippingMethods);
}
