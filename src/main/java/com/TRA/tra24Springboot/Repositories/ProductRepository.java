package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> { //just remove Integer

    @Query("SELECT pi from product p WHERE pi.sku =:sku")
    Product getByIdNumber(@Param("sku") String sku);

    @Query("SELECT pd from product pd  WHERE pd.productDetails =:productDetails")
    Product getByProductDetails(@Param("ProductDetails") String productDetails);


    //Create new query to select specific data in Product table

}
