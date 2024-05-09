package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//This Product API
@RestController
@RequestMapping("/product") //This is the main directory for Product API
public class ProductController {

     Product globalProduct = new Product(); //This is for saving and displaying the product data

    @PostMapping("add") //This is path /add for adding Product
    public Product addProduct(){

        Product product = new Product(); //This is Product class

        ProductDetails productDetails = new ProductDetails(); //This is Product Details

        productDetails.setId(1);
        productDetails.setName("Iphone 14");
        productDetails.setColor("Black");
        productDetails.setSize("Small");
        productDetails.setPrice(10d);
        productDetails.setCountryOfOrigin("USA");
        productDetails.setDescription("Apple Product");

        product.setProductDetails(productDetails);
        product.setSku(UUID.randomUUID());
        product.setCategory("Electronics");
        product.setQuantity(1);
        product.setId(1);
        product.setIsActive(Boolean.TRUE);
        product.setCreatedDate(new Date());

        globalProduct = product;

        return product;
    }

    @PostMapping("delete/{id}") //This is path /delete for Deleting Product
    public String deleteProduct(@PathVariable Integer id){

            if(globalProduct.getId().equals(id)){
                globalProduct.setIsActive(Boolean.FALSE);
                System.out.println(globalProduct.toString());

        }
        return "Success!";
    }

    @PutMapping("update") //This is path /update for Updating The product information
    public Product updateProduct(@RequestBody Product userProduct){


        ProductDetails pd = userProduct.getProductDetails();
        pd.setUpdatedDate(new Date());

        userProduct.setProductDetails(pd);
        userProduct.setUpdatedDate(new Date());

        globalProduct = userProduct;
        return globalProduct;
    }

    @GetMapping("get") //This is path /get for getting all the information about the product
    public Product reportProduct(){
        System.out.println("Retrieving product: " + globalProduct);
        return  globalProduct;
    }



}
