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

// Hint: The main purpose of this Controller is just to get all other controllers and fetch their existing information

//This is a Report API
@RestController
@RequestMapping("/report") //This is the main Directory for Report
public class ReportController {
    @Autowired
    ProductController productController; //This is to get all existing Products
    OrderController orderController; //This is to get all existing Orders
    InventoryController inventoryController; //This is to get all existing Inventory
    SupplierController supplierController; //This is to get all existing Supplier

    @GetMapping("product") //This is for getting report for product information
    public Product reportProduct(@RequestBody Product product){
        try {
            return productController.saveProduct(product);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get product report", e);
        }
    }

    @GetMapping("order") //This is for getting report for order information
    public Order reportOrder(@RequestBody Order order){
        try {
            return orderController.saveOrder(order);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get order report", e);
        }
    }

    @GetMapping("inventory") //This is for getting report for inventory information
    public Inventory reportInventory(@RequestBody Inventory inventory){
        try {
            return inventoryController.saveInventory(inventory);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get inventory report", e);
        }
    }

    @GetMapping("supplier") //This is for getting report for supplier information
    public Supplier reportSupplier(@RequestBody Supplier supplier){
        try {
            return supplierController.saveSupplier(supplier);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get supplier report", e);
        }
    }
}
