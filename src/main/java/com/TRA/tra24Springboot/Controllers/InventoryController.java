package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is Inventory API
@RestController
@RequestMapping("inventory") //This is the main Directory for the Inventory API
public class InventoryController {

    @Autowired
    InventoryServices inventoryServices;

    @PostMapping("save") //This is to save all data in Inventory
    public Inventory saveInventory(@RequestBody Inventory inventory){ //This is to save all data in Inventory DataBase
        try {
            return inventoryServices.saveInventory(inventory);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save inventory", e);
        }
    }

    @PostMapping("delete") //This is to delete single element from Inventory
    public String deleteInventory(@RequestParam String managerName){
        try {
            inventoryServices.deleteInventory(managerName);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete inventory by manager name", e);
        }
    }

    @PostMapping("deleteByLocation") //This to delete multiples elements in Inventory
    public String deleteInventoryByLocation(@RequestParam String loc){
        try {
            inventoryServices.deleteInventoryByLocation(loc);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete inventory by location", e);
        }
    }

    //Updated here

    @GetMapping("getAll")
    public List<InventoryDTO> getInventory(){
        try {
            return inventoryServices.getInventory();
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get inventory", e);
        }
    }
}
