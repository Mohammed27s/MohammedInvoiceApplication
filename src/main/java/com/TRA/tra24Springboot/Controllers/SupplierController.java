package com.TRA.tra24Springboot.Controllers;

//This is Supplier API

import com.TRA.tra24Springboot.Models.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/supplier") //This is the main directory
public class SupplierController {

    ProductController productSupplier = new ProductController(); //The use of this is for fetching the exiting data in Product
    OrderController orderSupplier = new OrderController(); //The use of this is for fetching the exiting data in order

    Supplier supplierSave = new Supplier(); //This is for saving and displaying Supplier information

    @PostMapping("add") //This is path add for Adding Supplier
    public Supplier addSupplier(){

        List<Product> exitingProductSupplier = new ArrayList<>();
        exitingProductSupplier.add(productSupplier.reportProduct());

        List<Order> exitingOrderSupplier = new ArrayList<>();
        exitingOrderSupplier.add(orderSupplier.reportOrder());

        Supplier newSupplier = new Supplier(); //This is supplier class

        newSupplier.setId(1);
        newSupplier.setCreatedDate(new Date());
        newSupplier.setContactDetails(new ContactDetails());
        newSupplier.setProductsOffered(exitingProductSupplier);
        newSupplier.setNextDeliveryTime(new Time(1,0,0));
        newSupplier.setExpectedProducts(exitingProductSupplier);
        newSupplier.setPaymentMethods(String.valueOf(PaymentMethods.BankTransfers));
        newSupplier.setShippingMethods("Vehicle");
        newSupplier.setMinimumOrderQuantity("One");
        newSupplier.setOrders(exitingOrderSupplier);
        newSupplier.setCompanyName("DHL");
        newSupplier.setIsActive(Boolean.TRUE);
        newSupplier.setCountry("Oman");
        newSupplier.setComplaints("No Complaints, Client is happy");

        supplierSave = newSupplier;

        return newSupplier;
    }

    @PostMapping("delete/{id}") //This is path /delete for Deleting Supplier
    public String deleteSupplier(@PathVariable Integer id){

        if(supplierSave.getId().equals(id)){
            supplierSave.setIsActive(Boolean.FALSE);
            System.out.println(supplierSave.toString());

        }
        return "Success!";
    }


    @PutMapping("update") //This is path /update for Updating The Supplier information
    public Supplier updateSupplier(@RequestBody Supplier userSupplier){


        userSupplier.setUpdatedDate(new Date()); //This is auto for date
        supplierSave = userSupplier; //This is for showing Updating Supplier

        return supplierSave;   //Displaying
    }


    @GetMapping("get")  //This for getting the report for Supplier
    public Supplier reportSupplier(){

        return supplierSave;  //Displaying
    }


}
