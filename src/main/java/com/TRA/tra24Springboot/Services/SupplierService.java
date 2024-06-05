package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.SupplierDTO;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.Supplier;
import com.TRA.tra24Springboot.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier){
        try {
            supplier.setCreatedDate(new Date());
            supplier.setIsActive(Boolean.TRUE);
            supplier.setCompanyName("DHL");
            supplier.setCountry("Oman");
            supplier.setProductsOffered(supplier.getProductsOffered());
            supplier.setNextDeliveryTime(Date.from(LocalDateTime.of(2024, 5, 28, 10, 0)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()));
            supplier.setExpectedProducts(supplier.getExpectedProducts());
            supplier.setComplaints("There is no Complaints from customer");
            supplier.setPaymentMethods(supplier.getPaymentMethods());
            supplier.setShippingMethods("Truck");
            supplier.setMinimumOrderQuantity("10");
            supplier.setOrders(supplier.getOrders());
            supplier.setContactDetails(supplier.getContactDetails());

            return supplierRepository.save(supplier);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save supplier", e);
        }
    }

    public String deleteSupplier(String companyName){
        try {
            Supplier supplierFromDb = supplierRepository.getBySupplierName(companyName);
            supplierFromDb.setIsActive(Boolean.FALSE);
            supplierRepository.save(supplierFromDb);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete supplier by company name", e);
        }
    }

    public String deleteSupplierByProductsOffered(List<Product> productsOffered){
        try {
            List<Supplier> suppliers = supplierRepository.getSupplierByProductOffer(productsOffered);
            List<Supplier> updateSupplierList = new ArrayList<>();

            for(Supplier supplier: suppliers){
                supplier.setIsActive(false);
                updateSupplierList.add(supplier);
            }

            supplierRepository.saveAll(updateSupplierList);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete supplier by products offered", e);
        }
    }

    public List<SupplierDTO> getSuppliers(){
        try {
            List<Supplier> suppliers = supplierRepository.findAll();
            return SupplierDTO.convertToDo(suppliers);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get suppliers", e);
        }
    }
}
