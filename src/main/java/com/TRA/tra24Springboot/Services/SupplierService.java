package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.SupplierDTO;
import com.TRA.tra24Springboot.Models.Supplier;
import com.TRA.tra24Springboot.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupplierService {


    @Autowired
    SupplierRepository supplierRepository;

    public Supplier saveSupplier(Supplier supplier){
        supplier.setCreatedDate(new Date());
        supplier.setIsActive(Boolean.TRUE);

        return supplierRepository.save(supplier);
    }

    public String deleteSupplier(String companyName){

        Supplier supplierFromDb = supplierRepository.getBySupplierName(companyName);
        supplierFromDb.setIsActive(Boolean.FALSE);
        supplierRepository.save(supplierFromDb);

        return "Success";

    }

    public String deleteSupplierByProductsOffered(String productsOffered){

        List<Supplier> suppliers = supplierRepository.getSupplierByProductOffer(productsOffered);
        List<Supplier> updateSupplierList = new ArrayList<>();

        for(Supplier supplier: suppliers){
            supplier.setIsActive(false);
            updateSupplierList.add(supplier);
        }

        supplierRepository.saveAll(updateSupplierList);
        return "Success";

    }

    public List<SupplierDTO>getSuppliers(){
        List<Supplier> suppliers = supplierRepository.findAll();
        return SupplierDTO.convertToDo(suppliers);
    }


}
