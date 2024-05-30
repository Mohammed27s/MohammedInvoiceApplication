package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.OrderDTO;
import com.TRA.tra24Springboot.Models.*;
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
        // Add more information for this class
        order.setCreatedDate(new Date());
        order.setIsActive(Boolean.TRUE);
        order.setOrderDate(new Date());
        order.setId(55542442);
        order.setProductsOrdered(order.getProductsOrdered());
        order.setCategoryName(order.getCategoryName());
        order.setOrderDate(order.getOrderDate()); // This could be changed later
        order.setStatus(OrderStatus.SHIPPED);
        order.setDescription("This is iPhone 14");
        order.setPaymentStatus(PaymentStatus.PAID);
        order.setPaymentType(PaymentType.BANK_TRANSFER);
        order.setDueDate(new Date());

        return orderRepository.save(order);
    }

    public String deleteOrder(String categoryName){ // Delete order by categoryName
        Order orderFromDb = orderRepository.getByOrderCategoryName(categoryName);
        orderFromDb.setIsActive(Boolean.FALSE);
        orderRepository.save(orderFromDb);
        return "Success";
    }

    public String deleteOrderByProductsOrdered(List<Product> productsOrdered){ // Delete a specific productOrder
        List<Order> orders = orderRepository.getByOrderProductsOrdered(productsOrdered);
        List<Order> updatedOrderList = new ArrayList<>();

        for(Order order: orders){
            order.setIsActive(false);
            updatedOrderList.add(order);
        }
        orderRepository.saveAll(updatedOrderList);
        return "Success";
    }

    public List<OrderDTO> getOrders(){ // This is to get all the orders that are existing
        List<Order> orders = orderRepository.findAll();
        return OrderDTO.convertToDTO(orders);
    }
}
