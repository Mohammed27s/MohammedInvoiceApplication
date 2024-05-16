package com.TRA.tra24Springboot.Services;


import com.TRA.tra24Springboot.DTO.ProductDTO;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Repositories.InventoryRepository;
import com.TRA.tra24Springboot.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;
    InventoryRepository inventoryRepository;


    public Product saveProduct(Product product){

        product.setCreatedDate(new Date());
        product.setIsActive(Boolean.TRUE);

        return productRepository.save(product);
    }

    public String deleteProduct(String sku){

        Product productFromDb = productRepository.getByIdNumber(sku);
        productFromDb.setIsActive(Boolean.FALSE);
        productRepository.save(productFromDb);
        return "Success";
    }

    public String deleteProductDetails(String productDetails){

        Product products = productRepository.getByProductDetails(productDetails);
        products.setIsActive(Boolean.FALSE);
        productRepository.save(products);
        return "Success";

    }


    public List<ProductDTO> getProducts(){ //This is to get all the exiting products from Database
        List<Product> products = productRepository.findAll();
        return ProductDTO.covertToDTO(products);
    }






}
