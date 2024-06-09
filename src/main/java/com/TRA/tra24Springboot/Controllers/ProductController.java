package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.ProductDTO;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Services.ProductServices;
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

    //all the APIs has Exception Handling
    @PostMapping("save") //This is to save all data in Product
    public Product saveProduct(@RequestBody Product product){
        try {
            return productServices.saveProduct(product);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save product", e);
        }
    }

    @PostMapping("delete") //This is to delete single element in Product
    public String deleteProduct(@RequestParam UUID sku){
        try {
            productServices.deleteProduct(sku);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete product by SKU", e);
        }
    }

    @PostMapping("deleteByProductDetails") //This is to delete multiples elements in Product
    public String deleteByProductDetails(@RequestParam ProductDetails productDetails){
        try {
            productServices.deleteProductDetails(productDetails);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete products by product details", e);
        }
    }

    //Updated here

    @GetMapping("getAll") //This is to get all existing products from Database
    public List<ProductDTO> getProduct(){
        try {
            return productServices.getProducts();
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get products", e);
        }
    }
}
