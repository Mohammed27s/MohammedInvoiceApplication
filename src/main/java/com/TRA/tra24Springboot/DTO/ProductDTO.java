package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// This is for converting Product data to DTO
@Data
public class ProductDTO {

    //This is Product DTO

    UUID productSku; //This is product unique id
    Integer productQuantity; //This is the product quantity
    String productCategory; //This is the product category

    public static ProductDTO convertDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductSku(product.getSku());
        productDTO.setProductQuantity(product.getQuantity());
        productDTO.setProductCategory(product.getCategory());

        return productDTO;
    }


    public static List<ProductDTO> covertToDTO(List<Product> productList){

        List<ProductDTO> productDTOS = new ArrayList<>(); //This is for saving all data as DTO

        for(Product productObjectFromDatabase: productList){

            ProductDTO dto = convertDTO(productObjectFromDatabase);
            productDTOS.add(dto);
        }

        return productDTOS;
    }


}
