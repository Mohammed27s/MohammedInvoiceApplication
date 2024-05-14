package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//This Product API
@RestController
@RequestMapping("product") //This is the main directory for Product API
public class ProductController {

    @Autowired
    ProductServices productServices;

    @PostMapping("save")
    public Product saveProduct(@RequestBody Product product){

        return productServices.saveProduct(product);
    }

    @PostMapping("delete")
    public String deleteProduct(@RequestParam String sku){
        productServices.deleteProduct(sku);
        return "Success";
    }

    @PostMapping("deleteByProductDetails")
    public String deleteByProductDetails(@RequestParam String productDetails){
        productServices.deleteProductDetails(productDetails);
        return "Success";
    }

}
