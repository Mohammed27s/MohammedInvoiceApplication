package com.TRA.tra24Springboot.Controllers;

//This is Supplier API

import com.TRA.tra24Springboot.Models.*;
import com.TRA.tra24Springboot.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("supplier") //This is the main directory to Supplier
public class SupplierController {

    @Autowired
    SupplierService supplierService;


    @PostMapping("save")
    public Supplier saveSupplier(@RequestBody Supplier supplier){

        return supplierService.saveSupplier(supplier);

    }

    @PostMapping("delete")
    public String deleteSupplier(@RequestParam String companyName){
        supplierService.deleteSupplier(companyName);
        return "Success";

    }

    @PostMapping("deleteByProductsOffered")
    public String deleteSupplierByProductsOffered(@RequestParam String pOffer){
        supplierService.deleteSupplierByProductsOffered(pOffer);
        return "Success";

    }





}
