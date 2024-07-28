package com.TRA.tra24Springboot.Repositories;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    private Order testOrder;
    private Product testProduct;

    @BeforeEach
    public void setUp() {
        // Initialize and persist ProductDetails
        ProductDetails productDetails = ProductDetails.builder()
                .description("Test Product Details")
                .build();

        entityManager.persist(productDetails);
        entityManager.flush();

        // Initialize and persist Product
        testProduct = Product.builder()
                .quantity(10)
                .category("Electronics")
                .sku(UUID.randomUUID())
                .productDetails(productDetails)
                .build();

        entityManager.persist(testProduct);
        entityManager.flush();

        // Initialize and persist Order
        testOrder = Order.builder()
                .categoryName("Electronics")
                .description("Test Order Description")
                .status(OrderStatus.PENDING)
                .productsOrdered(Arrays.asList(testProduct))
                .build();

        entityManager.persist(testOrder);
        entityManager.flush();
    }

    @Test
    public void whenFindByCategoryName_thenReturnOrder() {
        // when
        Order found = orderRepository.getByOrderCategoryName(testOrder.getCategoryName());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getCategoryName()).isEqualTo(testOrder.getCategoryName());
    }

    @Test
    public void whenFindByProductsOrdered_thenReturnOrderList() {
        // when
        List<Order> found = orderRepository.getByOrderProductsOrdered(Arrays.asList(testProduct));

        // then
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getProductsOrdered()).contains(testProduct);
    }

    @Test
    public void whenFindByDescription_thenReturnOrder() {
        // when
        Order found = orderRepository.getByOrderDescription(testOrder.getDescription());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getDescription()).isEqualTo(testOrder.getDescription());
    }

    @Test
    public void whenFindByStatus_thenReturnOrder() {
        // when
        Order found = orderRepository.getByOrdersStatus(testOrder.getStatus());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getStatus()).isEqualTo(testOrder.getStatus());
    }

    @Test
    public void whenFindByCategoryName_notExist_thenReturnNull() {
        // when
        Order found = orderRepository.getByOrderCategoryName("Nonexistent Category");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByProductsOrdered_notExist_thenReturnEmptyList() {
        // when
        List<Order> found = orderRepository.getByOrderProductsOrdered(Arrays.asList(new Product()));

        // then
        assertThat(found).isEmpty();
    }

    @Test
    public void whenFindByDescription_notExist_thenReturnNull() {
        // when
        Order found = orderRepository.getByOrderDescription("Nonexistent Description");

        // then
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByStatus_notExist_thenReturnNull() {
        // when
        Order found = orderRepository.getByOrdersStatus(OrderStatus.SHIPPED);

        // then
        assertThat(found).isNull();
    }
}
