package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT c from Order c WHERE c.categoryName =:categoryName")
    Order getByOrderCategoryName(@Param("categoryName") String categoryName);

    @Query("SELECT po from Order po WHERE po.id =:id")
    Order getByOrderProductsOrdered(@Param("id") List<Product> id);

    //Create new query to select specific data in order table
}
