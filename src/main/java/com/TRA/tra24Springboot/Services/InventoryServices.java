package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service //This is Inventory Service
public class InventoryServices {

    @Autowired
    InventoryRepository inventoryRepository;

    public Inventory saveInventory(Inventory inventory){ //This is for saving the inventory  Information
        //Add more information for this class


        inventory.setCreatedDate(new Date());
        inventory.setIsActive(Boolean.TRUE);
        inventory.setId(55656565);
        inventory.setLocation("NewYork");
        inventory.setManager("Mohammed");
        inventory.setWorkers(new ArrayList<>(Arrays.asList("Mohammed", "John", "Noor")));
        inventory.setSupplier("DHL");
        inventory.setProducts(inventory.getProducts());
        inventory.setPhoneNumber("+968 95577223");
        inventory.setOpeningHours("10:00 AM");
        inventory.setClosingHours("10:00 PM");

        return inventoryRepository.save(inventory);
    }

    public String deleteInventory(String managerName) {

        Inventory inventoryFromDb = inventoryRepository.getByInventoryManagerName(managerName);
        inventoryFromDb.setIsActive(Boolean.FALSE);
        inventoryRepository.save(inventoryFromDb);
        return "Success";

    }

    public String deleteInventoryByLocation(String location){

        List<Inventory> inventories = inventoryRepository.getInventoryByLocation(location);
        List<Inventory> updatedInventoryList = new ArrayList<>();

        for(Inventory inventory: inventories) {

            inventory.setIsActive(false);
            updatedInventoryList.add(inventory);
        }

        inventoryRepository.saveAll(updatedInventoryList);
        return "Success";

    }
    public List<InventoryDTO>getInventory(){ //This to hide sensitive information
        List<Inventory> inventories = inventoryRepository.findAll();
        return InventoryDTO.convertToDTO(inventories);
    }



}
