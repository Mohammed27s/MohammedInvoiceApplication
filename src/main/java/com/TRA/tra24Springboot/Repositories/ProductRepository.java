package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Integer> { //just remove Integer

    @Query("SELECT pi from Product pi WHERE pi.sku =:sku") //This query for getting sku from the Database
    Product getByIdNumber(@Param("sku") UUID sku);

    @Query("SELECT pd from Product pd  WHERE pd.productDetails =:productDetails") //This query for getting product Details from Database
    Product getByProductDetails(@Param("productDetails") ProductDetails productDetails);

    @Query("SELECT pq from Product pq WHERE pq.quantity =:qua") //This query for getting product quantity from Database
    Product getByProductQuantity(@Param("qua") Integer quantity);

    @Query("SELECT pc from Product pc WHERE pc.category =:cat") //This query for getting product category from Database
    Product getByProductCategory(@Param("cat") String category);



}
