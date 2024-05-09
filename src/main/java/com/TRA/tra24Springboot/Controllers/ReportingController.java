package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportingController {

    private final SupplierController supplierController;
    private final InventoryController inventoryController;
    private final OrderController orderController;
    private final ProductController productController;


    @Autowired //From here added
    public ReportingController(SupplierController supplierController,
                               InventoryController inventoryController,
                               OrderController orderController,
                               ProductController productController) {
        this.supplierController = supplierController;
        this.inventoryController = inventoryController;
        this.orderController = orderController;
        this.productController = productController;
    } //To here add

    @GetMapping("getSupplier")
    public Supplier reportSupplier() {
        return supplierController.reportSupplier();
    }

    @GetMapping("getInventory")
    public Inventory reportInventory() {
        return inventoryController.reportInventory();
    }

    @GetMapping("getOrder")
    public Order reportOrder() {
        return orderController.reportOrder();
    }

    @GetMapping("getProduct")
    public Product reportProduct() {
        return productController.reportProduct();
    }
}
