package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    @Query("SELECT i from Inventory i WHERE i.manager =:managerName")
    Inventory getByInventoryManagerName(@Param("managerName") String managerName);

    @Query("SELECT il from Inventory il WHERE il.location =:loc")
    List<Inventory> getInventoryByLocation(@Param("loc") String location);


}
