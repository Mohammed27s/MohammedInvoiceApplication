package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ProductServicesTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServices productServices;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testSaveProduct() {
        String categoryName = "Electronics";
        Integer quantity = 200;

        // Prepare mock data

        Product product = Product.builder()
                .category(categoryName)
                .isActive(true)
                .quantity(quantity)
                .build();

    }



}