package com.TRA.tra24Springboot.Controllers;

//This is Supplier API

import com.TRA.tra24Springboot.DTO.SupplierDTO;
import com.TRA.tra24Springboot.Models.*;
import com.TRA.tra24Springboot.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("supplier") //This is the main directory to Supplier
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("save")
    public Supplier saveSupplier(@RequestBody Supplier supplier){
        try {
            return supplierService.saveSupplier(supplier);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save supplier", e);
        }
    }

    @PostMapping("delete")
    public String deleteSupplier(@RequestParam String companyName){
        try {
            supplierService.deleteSupplier(companyName);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete supplier by company name", e);
        }
    }

    @PostMapping("deleteByProductsOffered")
    public String deleteSupplierByProductsOffered(@RequestParam List<Product> pOffer){
        try {
            supplierService.deleteSupplierByProductsOffered(pOffer);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete suppliers by products offered", e);
        }
    }

    //Updated here

    @GetMapping("getAll")
    public List<SupplierDTO> getSupplier(){
        try {
            return supplierService.getSuppliers();
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get suppliers", e);
        }
    }
}
