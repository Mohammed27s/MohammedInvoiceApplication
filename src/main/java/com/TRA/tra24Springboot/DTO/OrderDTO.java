package com.TRA.tra24Springboot.DTO;


import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.PaymentStatus;
import com.TRA.tra24Springboot.Models.PaymentType;
import com.TRA.tra24Springboot.Models.Product;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//This is for Order data to DTO
@Data
public class OrderDTO {

    List<Product> productsOrdered;
    String categoryName;
    Date orderDate;
    PaymentStatus paymentStatus;
    PaymentType paymentType;

    //This is for convert each variable above to DTO

    public static OrderDTO convertToDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setProductsOrdered(order.getProductsOrdered());
        orderDTO.setCategoryName(order.getCategoryName());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setPaymentStatus(order.getPaymentStatus());
        orderDTO.setPaymentType(order.getPaymentType());

        return orderDTO;
    }

    //This is for converting the whole exiting data to DTOs
    public static List<OrderDTO> convertToDTO(List<Order> orderList){

        List<OrderDTO> orderDTOS = new ArrayList<>(); //This is for saving all DTOs values

        for(Order orderObjectFromDataBase: orderList){

            OrderDTO dto = convertToDTO(orderObjectFromDataBase);
            orderDTOS.add(dto);
        }

        return orderDTOS;
    }



}
