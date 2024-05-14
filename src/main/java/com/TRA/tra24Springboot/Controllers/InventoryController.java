package com.TRA.tra24Springboot.Controllers;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//This is Inventory API
@RestController
@RequestMapping("inventory") //This is the main Directory for the Inventory API
public class InventoryController {

    @Autowired
    InventoryServices inventoryServices;


    @PostMapping("save") //This is to save all data in Inventory
    public Inventory saveInventory(@RequestBody Inventory inventory){ //This is to save all data in Inventory DataBase

        return inventoryServices.saveInventory(inventory);
    }

    @PostMapping("delete") //This is to delete single element from Inventory
    public String deleteInventory(@RequestParam String managerName){
        inventoryServices.deleteInventoryByLocation(managerName);
        return "Success";
    }

    @PostMapping("deleteByLocation") //This to delete multiples elements in Inventory
    public String deleteInventoryByLocation(@RequestParam String loc){
        inventoryServices.deleteInventoryByLocation(loc);
        return "Success";
    }


}






