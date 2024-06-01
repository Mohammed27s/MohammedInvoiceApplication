package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.ProductDTO;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Services.ProductServices;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//This Product API
@RestController
@RequestMapping("/product") //This is the main directory for Product API
public class ProductController {

    @Autowired
    ProductServices productServices;

    @PostMapping("save") //This is to save all data in Product
    public Product saveProduct(@RequestBody Product product){
        return productServices.saveProduct(product);
    }

    @PostMapping("delete") //This is to delete single element in Product
    public String deleteProduct(@RequestParam UUID sku){
        productServices.deleteProduct(sku);
        return "Success";
    }

    @PostMapping("deleteByProductDetails") //This is to delete multiples elements in Product
    public String deleteByProductDetails(@RequestParam ProductDetails productDetails){
        productServices.deleteProductDetails(productDetails);
        return "Success";
    }

    @GetMapping("getAll")
    public List<ProductDTO> getProduct(){
        return productServices.getProducts();
    }

}
