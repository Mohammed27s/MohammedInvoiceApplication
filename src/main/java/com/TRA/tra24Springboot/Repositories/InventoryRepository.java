package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    @Query("SELECT i from Inventory i WHERE i.manager =:managerName") //This query for getting Inventory managerName from Database
    Inventory getByInventoryManagerName(@Param("managerName") String managerName);

    @Query("SELECT il from Inventory il WHERE il.location =:loc") //This query for getting Inventory location from Database
    List<Inventory> getInventoryByLocation(@Param("loc") String location);

    @Query("SELECT sn from Inventory sn WHERE sn.supplier =:sup") //This query for getting Inventory supplier from Database
    Inventory getInventoryBySupplier(@Param("sup") String supplier);

    @Query("SELECT ph from Inventory ph WHERE ph.phoneNumber =:ph") //This query fro getting Inventory phoneNumber from Database
    Inventory getInventoryByPhoneNumber(@Param("ph") String phoneNumber);



}
