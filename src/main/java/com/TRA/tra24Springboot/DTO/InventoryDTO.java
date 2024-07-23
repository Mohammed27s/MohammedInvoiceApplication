package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


//This is for converting Inventory Data to DTO
@Data
public class InventoryDTO {

    //These information will be stored securely
    List<Product> products;
    String location;
    String manager;
    List<String> workers;


    //This is for convert each variable above to DTO
    public static InventoryDTO convertToDTO(Inventory inventory){

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setProducts(inventory.getProducts());
        inventoryDTO.setLocation(inventory.getLocation());
        inventoryDTO.setManager(inventory.getManager());
        inventoryDTO.setWorkers(inventory.getWorkers());

        return inventoryDTO;
    }

    //This is for converting the whole exiting data to DTOs

    public static  List<InventoryDTO> convertToDTO(List<Inventory> inventoryList){

        List<InventoryDTO> inventoryDTOS = new ArrayList<>();

        for(Inventory inventoryObjectFromDatabase: inventoryList){

            InventoryDTO dto = convertToDTO(inventoryObjectFromDatabase);
            inventoryDTOS.add(dto);
        }

        return inventoryDTOS;
    }



}
