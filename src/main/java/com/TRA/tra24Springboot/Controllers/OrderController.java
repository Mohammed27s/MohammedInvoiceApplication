package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.OrderDTO;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is Order API
@RestController
@RequestMapping("/order") // This is the main Directory for order
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("save") // This is to save all order information
    public Order saveOrder(@RequestBody Order order){
        try {
            return orderService.saveOrder(order);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save order", e);
        }
    }

    @PostMapping("delete") // This is to delete one element from Order Database
    public String deleteOrder(@RequestParam String categoryName){
        try {
            orderService.deleteOrder(categoryName);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete order by category name", e);
        }
    }

    //Updated here
    @PostMapping("deleteByProductsOrdered") // This to delete the whole orders information in order Database
    public String deleteOrderByProductsOrdered(@RequestBody List<Product> productsOrdered){ // There is issue here
        try {
            orderService.deleteOrderByProductsOrdered(productsOrdered);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete order by products ordered", e);
        }
    }

    @GetMapping("getAll") //This is to get all existing information about Order from Database
    public List<OrderDTO> getOrder(){
        try {
            return orderService.getOrders();
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get orders", e);
        }
    }
}
