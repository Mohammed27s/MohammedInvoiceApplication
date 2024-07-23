package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.ContactDetailDTO;
import com.TRA.tra24Springboot.Models.ContactDetails;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Repositories.ContactDetailRepository;
import com.TRA.tra24Springboot.Repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;


class ContactDetailServiceTest {

    @Mock
    private ContactDetailRepository contactDetailRepository;
    @Mock
    private ProductRepository productRepository;


    @InjectMocks
    private ContactDetailService contactDetailService;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveContactDetail(){
        String address = "Springfield";
        String PhoneNumber = "965433676";
        // Prepare mock data

        ContactDetails contactDetails = ContactDetails.builder()
                .address(address)
                .phoneNumber(PhoneNumber)
                .build();
        //add isActive also

        List<Product> products = Arrays.asList(
                Product.builder()
                        .category("Sneakers")
                        .quantity(11)
                        .build(),
                Product.builder()
                        .category("Food")
                        .quantity(4)
                        .build()
        );

        when(contactDetailRepository.save(any(ContactDetails.class))).thenReturn(contactDetails);
        when(productRepository.saveAll(any(ArrayList.class))).thenReturn(products);


        ContactDetails savedContactDetails = contactDetailService.saveContactDetails(ContactDetails.builder().build());


        verify(contactDetailRepository, times(1)).save(any(ContactDetails.class));


        assertEquals(contactDetails.getEmail(), savedContactDetails.getPhoneNumber());


        List<ContactDetailDTO> contactDetailDTOS = contactDetailService.getContactDetails();

        verify(contactDetailRepository, times(1)).findAll();

        assertEquals(1, contactDetailDTOS.size());
        assertEquals("Springfiled Elementary", contactDetailDTOS.get(0).getPostalCode());



    }



}