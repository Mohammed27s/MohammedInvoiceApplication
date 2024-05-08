package com.TRA.tra24Springboot.Controllers;


import com.TRA.tra24Springboot.Models.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//This is Order API
@RestController
@RequestMapping("/order") //This is the main Directory for order
public class OrderController {

    ProductController orderProduct = new ProductController(); //this is for getting an existing product from product API
    Order orderSave = new Order(); //This to save the  new order and display it the same time

    @PostMapping("add") //This is /add path for adding new order
    public Order addOrder(){

        Order newOrder = new Order(); //This order class
        List<Product> exitingProductOrder = new ArrayList<>(); //This for saving the exiting product in order
        exitingProductOrder.add(orderProduct.reportProduct());


        newOrder.setId(1);
        newOrder.setOrderDate(new Date());
        newOrder.setProductsOrdered(exitingProductOrder);
        newOrder.setCategoryName("Electronics");
        newOrder.setDescription("Iphone 14");
        newOrder.setDueDate(new Date());
        newOrder.setStatus(OrderStatus.IN_PROGRESS);
        newOrder.setPaymentType(PaymentType.BANK_TRANSFER);
        newOrder.setPaymentStatus(PaymentStatus.PAID);

        orderSave = newOrder; //This for later use for updating

        return newOrder;
    }

    @PostMapping("delete/{id}") //This is for deleting Order
    public String deleteOrder(@PathVariable Integer id){

        if(orderSave.getId().equals(id)){
            orderSave.setIsActive(Boolean.FALSE);
            System.out.println(orderSave.toString());

        }
        return "Success!"; //This is to let the user knowing his deleting is done successfully
    }

    @PutMapping("update") //This is for Updating Order
    public Order updateOrder(@RequestBody Order userOrder){ //RequestBody is for getting /add Body API or path
        // and updating it with new values

        orderSave.setUpdatedDate(new Date()); //This is auto update date
        orderSave = userOrder; //This is for showing Updating Order

        return orderSave;   //Displaying
    }


    @GetMapping("get")  //This for getting the report for Order
    public Order reportOrder(){

        return orderSave;  //Displaying
    }


}
