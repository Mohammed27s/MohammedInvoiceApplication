package com.TRA.tra24Springboot.DTO;


import com.TRA.tra24Springboot.Models.ContactDetails;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.Supplier;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SupplierDTO {

    ContactDetails contactDetails;
    List<Product> productsOffered;
    Date nextDeliveryTime;
    List<Product> expectedProducts;
    String paymentMethods;
    String shippingMethods;
    String minimumOrderQuantity;

    //This is for convert each variable above to DTO
    public static SupplierDTO convertTODTO(Supplier supplier){
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setContactDetails(supplier.getContactDetails());
        supplierDTO.setProductsOffered(supplier.getProductsOffered());
        supplierDTO.setNextDeliveryTime(supplier.getNextDeliveryTime());
        supplierDTO.setExpectedProducts(supplier.getExpectedProducts());
        supplierDTO.setPaymentMethods(supplier.getPaymentMethods());
        supplierDTO.setShippingMethods(supplier.getShippingMethods());
        supplierDTO.setMinimumOrderQuantity(supplier.getMinimumOrderQuantity());

        return supplierDTO;
    }

    //This is for converting the whole exiting data to DTOs

    public static List<SupplierDTO> convertToDo(List<Supplier> supplierList){
        List<SupplierDTO> supplierDTOS = new ArrayList<>();

        for(Supplier supplierObjectFromDatabase: supplierList){

            SupplierDTO dto = convertTODTO(supplierObjectFromDatabase);
            supplierDTOS.add(dto);
        }

        return supplierDTOS;
    }



}
