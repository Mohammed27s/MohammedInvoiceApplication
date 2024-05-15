package com.TRA.tra24Springboot.Controllers;


import com.TRA.tra24Springboot.Models.*;
import com.TRA.tra24Springboot.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//This is Order API
@RestController
@RequestMapping("order") //This is the main Directory for order
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("save") //This is to save all order information
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PostMapping("delete") //This is to delete one element from Order Database
    public String deleteOrder(@RequestParam String categoryName){
        orderService.deleteOrder(categoryName);
        return "Success";
    }

    @PostMapping("deleteByProductsOrdered") //This to delete the whole orders information in
                                           //in order Database
    public String deleteOrderByProductsOrdered(@RequestParam String pro){
        orderService.deleteOrderByProductsOrdered(pro);
        return "Success";
    }


}
