package com.TRA.tra24Springboot.Controllers;


import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.Supplier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This is Reporting API

@RestController
@RequestMapping("/report") //This is the main directory for Reporting API
public class ReportingController {


    SupplierController supplierReport = new SupplierController();
    InventoryController inventoryReport = new InventoryController();
    OrderController orderReport = new OrderController();
    ProductController productReport = new ProductController();

    //This is fetching data report for Supplier
    @GetMapping("GetSupplier")  //This for getting the report for Supplier
    public Supplier reportSupplier(){

        return supplierReport.reportSupplier();  //Displaying
    }

    //This is fetching data report for Inventory
    @GetMapping("GetInventory")  //This for getting the report for Inventory
    public Inventory reportInventory(){

        return inventoryReport.reportInventory();  //Displaying
    }

    //This is fetching data report for Order
    @GetMapping("GetOrder")  //This for getting the report for Order
    public Order reportOrder(){

        return orderReport.reportOrder();  //Displaying
    }

    //This is fetching data report for Product
    @GetMapping("GetProduct") //This is path /get for getting all the information about the product
    public Product reportProduct(){

        return productReport.reportProduct();
    }



}
