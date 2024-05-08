package com.TRA.tra24Springboot.Controllers;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//This is Inventory API
@RestController
@RequestMapping("/inventory") //This is the main Directory for the Inventory API
public class InventoryController {

    ProductController allInventoryProduct = new ProductController(); //This is for getting all exiting products
    Inventory inventoryStore = new Inventory(); //This is Inventory class

    @PostMapping("add") //This is path /add for adding new inventory
    public Inventory addInventory(){

        List<Product> exitingProduct = new ArrayList<>();
        exitingProduct.add(allInventoryProduct.reportProduct());
        Inventory newInventory = new Inventory();

        newInventory.setId(1);
        newInventory.setCreatedDate(new Date());
        newInventory.setIsActive(Boolean.TRUE);
        newInventory.setProducts(exitingProduct);
        newInventory.setLocation("Muscat");
        newInventory.setManager("Mohammed Salim");
        newInventory.setSupplier("DHL");
        newInventory.setPhoneNumber("+968 976756564");
        newInventory.setOpeningHours("9:00 AM");
        newInventory.setClosingHours("10:00 PM");

        inventoryStore = newInventory;

         return newInventory; //This is for Displaying all new added values
    }


    @PostMapping("delete/{id}") //This is for deleting Inventory
    public String deleteInventory(@PathVariable Integer id){


            if(inventoryStore.getId().equals(id)){
                inventoryStore.setIsActive(Boolean.FALSE);
                System.out.println(inventoryStore.toString());

            }
            return "Success!"; //This is to let the user knowing his deleting is done successfully
    }


    @PutMapping("update") //This is for Updating Inventory
    public Inventory updateInventory(@RequestBody Inventory userInventory){ //RequestBody is for getting /add Body API or path
        // and updating it with new values

        userInventory.setUpdatedDate(new Date()); //This is auto update date
        inventoryStore = userInventory; //This is for showing Updating Inventory

        return inventoryStore;   //Displaying

    }


    @GetMapping("get")  //This for getting the report for Inventory
    public Inventory reportInventory(){

        return inventoryStore;  //Displaying
    }
}






