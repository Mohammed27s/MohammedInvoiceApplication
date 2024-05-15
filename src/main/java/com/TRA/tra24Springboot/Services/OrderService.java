package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(Order order){

        order.setCreatedDate(new Date());
        order.setIsActive(Boolean.TRUE);

        return orderRepository.save(order);
    }

    public String deleteOrder(String categoryName){

        Order orderFromDb = orderRepository.getByOrderCategoryName(categoryName);
        orderFromDb.setIsActive(Boolean.FALSE);
        orderRepository.save(orderFromDb);

        return "Success";
    }

    public String deleteOrderByProductsOrdered(String productsOrdered){

        List<Order> orders = orderRepository.getByOrderProductsOrdered(productsOrdered);
        List<Order> updatedOrderList = new ArrayList<>();

        for(Order order: orders){
            order.setIsActive(false);
            updatedOrderList.add(order);
        }
        orderRepository.saveAll(updatedOrderList);
        return "Success";
    }




}
