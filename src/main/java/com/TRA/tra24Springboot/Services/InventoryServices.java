package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service //This is Inventory Service
public class InventoryServices {

    @Autowired
    InventoryRepository inventoryRepository;

    public Inventory saveInventory(Inventory inventory){ //This is for saving the inventory  Information
        try {
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
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to save inventory", e);
        }
    }

    public String deleteInventory(String managerName) {
        try {
            Inventory inventoryFromDb = inventoryRepository.getByInventoryManagerName(managerName);
            inventoryFromDb.setIsActive(Boolean.FALSE);
            inventoryRepository.save(inventoryFromDb);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete inventory by manager name", e);
        }
    }

    public String deleteInventoryByLocation(String location){
        try {
            List<Inventory> inventories = inventoryRepository.getInventoryByLocation(location);
            List<Inventory> updatedInventoryList = new ArrayList<>();

            for(Inventory inventory: inventories) {
                inventory.setIsActive(false);
                updatedInventoryList.add(inventory);
            }

            inventoryRepository.saveAll(updatedInventoryList);
            return "Success";
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to delete inventory by location", e);
        }
    }

    public List<InventoryDTO>getInventory(){ //This to hide sensitive information
        try {
            List<Inventory> inventories = inventoryRepository.findAll();
            return InventoryDTO.convertToDTO(inventories);
        } catch (Exception e) {
            // Handle exception
            throw new RuntimeException("Failed to get inventory", e);
        }
    }


    //This is Service Executor

    public void parallelComputing() {

        /*
        Fixed Thread Pool (newFixedThreadPool(int nThreads))
        A fixed-size thread pool with a specified number of threads.
        If all threads are busy, new tasks are placed in a queue until a thread becomes available.
        */
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /*
        Cached Thread Pool (newCachedThreadPool())
        A pool that creates new threads as needed but reuses previously constructed threads when they are available.
        Suitable for applications that execute many short-lived asynchronous tasks
        */
        //ExecutorService executor = Executors.newCachedThreadPool();

        /*
        Single Thread Executor (newSingleThreadExecutor())
        A thread pool with only one thread. Tasks are executed sequentially.
        Ensures that tasks are executed in the order they are submitted.
        */
        //ExecutorService executor = Executors.newSingleThreadExecutor();

        /*
        Scheduled Thread Pool (newScheduledThreadPool(int corePoolSize))
        A thread pool that can schedule tasks to run after a given delay or to execute periodically.
        Useful for tasks that need to run at regular intervals.
        */
        //ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);


        // Create and submit 5 tasks to the executor service
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " is completed");
            });
        }

        // Shut down the executor service
        executorService.shutdown();
    }


}
