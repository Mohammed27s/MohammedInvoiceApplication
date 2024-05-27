package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.OrderDTO;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public Order saveOrder(Order order){
    //Add more information for this class
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

    public String deleteOrderByProductsOrdered(List<Product> productsOrdered){ //Delete a specific order class

        List<Order> orders = Collections.singletonList(orderRepository.getByOrderProductsOrdered(productsOrdered));
        List<Order> updatedOrderList = new ArrayList<>();

        for(Order order: orders){
            order.setIsActive(false);
            updatedOrderList.add(order);
        }
        orderRepository.saveAll(updatedOrderList);
        return "Success";
    }

    public List<OrderDTO>getOrders(){
        List<Order> orders = orderRepository.findAll();
        return OrderDTO.convertToDTO(orders);

    }

}
