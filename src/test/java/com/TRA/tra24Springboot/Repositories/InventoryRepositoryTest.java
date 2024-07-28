package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InventoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InventoryRepository inventoryRepository;

    private Inventory testInventory;

    @BeforeEach
    public void setUp() {
        // Initialize and persist test data using the builder pattern
        testInventory = Inventory.builder()
                .manager("John Doe")
                .location("Warehouse A")
                .supplier("Supplier X")
                .phoneNumber("123-456-7890")
                .build();

        entityManager.persist(testInventory);
        entityManager.flush();
    }

    @Test
    public void whenFindByInventoryManagerName_thenReturnInventory() {
        // when
        Inventory found = inventoryRepository.getByInventoryManagerName(testInventory.getManager());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getManager()).isEqualTo(testInventory.getManager());
    }

    @Test
    public void whenFindByLocation_thenReturnInventoryList() {
        // when
        List<Inventory> found = inventoryRepository.getInventoryByLocation(testInventory.getLocation());

        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getLocation()).isEqualTo(testInventory.getLocation());
    }

    @Test
    public void whenFindBySupplier_thenReturnInventory() {
        // when
        Inventory found = inventoryRepository.getInventoryBySupplier(testInventory.getSupplier());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getSupplier()).isEqualTo(testInventory.getSupplier());
    }

    @Test
    public void whenFindByPhoneNumber_thenReturnInventory() {
        // when
        Inventory found = inventoryRepository.getInventoryByPhoneNumber(testInventory.getPhoneNumber());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getPhoneNumber()).isEqualTo(testInventory.getPhoneNumber());
    }

    @Test
    public void whenFindByInventoryManagerName_notExist_thenReturnNull() {
        // when
        Inventory found = inventoryRepository.getByInventoryManagerName("Nonexistent Manager");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByLocation_notExist_thenReturnEmptyList() {
        // when
        List<Inventory> found = inventoryRepository.getInventoryByLocation("Nonexistent Location");

        // then
        assertThat(found).isEmpty();
    }

    @Test
    public void whenFindBySupplier_notExist_thenReturnNull() {
        // when
        Inventory found = inventoryRepository.getInventoryBySupplier("Nonexistent Supplier");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByPhoneNumber_notExist_thenReturnNull() {
        // when
        Inventory found = inventoryRepository.getInventoryByPhoneNumber("000-000-0000");

        // then
        assertThat(found).isNull();
    }
}
