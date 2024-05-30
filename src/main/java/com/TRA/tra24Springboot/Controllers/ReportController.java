package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Hint: The main propose of this Controller is just to get all other controller and fetch their exiting information

//This is a Report API
@RestController
@RequestMapping("report") //This is the main Directory for Report
public class ReportController {
    @Autowired
    ProductController productController; //This is to get all exiting Products
    OrderController orderController; //This is to get all exiting Orders
    InventoryController inventoryController; //This is to get all exiting Inventory
    SupplierController supplierController; //This is to get all exiting Supplier


    @GetMapping("product") //This is for getting report for product information
    public Product reportProduct(@RequestBody Product product){
        return productController.saveProduct(product);
    }

    @GetMapping("order") //This is for getting report for order information
    public Order reportOrder(@RequestBody Order order){
        return orderController.saveOrder(order);
    }

    @GetMapping("inventory") //This is for getting report for inventory information
    public Inventory reportInventory(Inventory inventory){
        return inventoryController.saveInventory(inventory);
    }

    @GetMapping("supplier") //This is for getting report for supplier information
    public Supplier reportSupplier(Supplier supplier){
        return supplierController.saveSupplier(supplier);
    }


}
