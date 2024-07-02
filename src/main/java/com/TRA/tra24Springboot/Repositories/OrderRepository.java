package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT c FROM Order c WHERE c.categoryName = :categoryName") //This query for getting Order categoryName from Database
    Order getByOrderCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT DISTINCT o FROM Order o JOIN o.productsOrdered p WHERE p IN :productsOrdered") //This query for getting Order productsOrdered from Database
    List<Order> getByOrderProductsOrdered(@Param("productsOrdered") List<Product> productsOrdered);

    @Query("SELECT pd FROM Order pd WHERE pd.description = :description") //This query for getting Order description from Database
    Order getByOrderDescription(@Param("description") String description);

    @Query("SELECT st FROM Order st WHERE st.status = :status") //This query for getting Order status from Database
    Order getByOrdersStatus(@Param("status") OrderStatus status);
}
