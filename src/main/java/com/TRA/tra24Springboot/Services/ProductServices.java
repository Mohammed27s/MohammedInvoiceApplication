package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.ProductDTO;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;

    //This is to save Product information
    public Product saveProduct(Product product){ //I added Exception Handling

        try {
            product.setCreatedDate(new Date());
            product.setId(565644455);
            product.setIsActive(Boolean.TRUE);
            product.setProductDetails(product.getProductDetails());
            product.setSku(UUID.randomUUID()); // This is to generate random unique id
            product.setQuantity(1);
            product.setCategory("Electronic");

            Product savedProduct = productRepository.save(product);

            // Print success message
            System.out.println("Product saved successfully with ID: " + savedProduct.getId());

            return savedProduct;
        } catch (Exception es) {
            // Print error message and rethrow exception
            System.err.println("Error saving product: " + es.getMessage());
            throw new RuntimeException("Failed to save product", es);
        }

        }

    public String deleteProduct(UUID sku) {
        try {
            Product productFromDb = productRepository.getByIdNumber(sku);
            productFromDb.setIsActive(Boolean.FALSE);
            productRepository.save(productFromDb);
            return "Success";
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
            throw new RuntimeException("Failed to delete product", e);
        }
    }

    // Delete product details method
    public String deleteProductDetails(ProductDetails productDetails) {
        try {
            // Retrieve product by details
            Product product = productRepository.getByProductDetails(productDetails);
            // Set product as inactive
            product.setIsActive(Boolean.FALSE);
            // Save product changes
            productRepository.save(product);
            return "Success"; // Return success message
        } catch (Exception e) {
            // Print error message and throw runtime exception
            System.err.println("Error deleting product details: " + e.getMessage());
            throw new RuntimeException("Failed to delete product details", e);
        }
    }

    //DTO
    public List<ProductDTO> getProducts() { // This is to get all the existing products from the Database
        try {
            List<Product> products = productRepository.findAll();
            return ProductDTO.covertToDTO(products);
        } catch (Exception e) {
            System.err.println("Error retrieving products: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve products", e);
        }
    }


}
