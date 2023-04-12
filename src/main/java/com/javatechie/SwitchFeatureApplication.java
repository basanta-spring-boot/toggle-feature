package com.javatechie;

import com.javatechie.dto.Order;
import com.javatechie.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class SwitchFeatureApplication {

    @Autowired
    private FeatureManager featureManager;

    public static final Feature NEW_PRODUCT = new NamedFeature("NEW_PRODUCT");

    public static final Feature DISCOUNT_APPLIED = new NamedFeature("DISCOUNT_APPLIED");
    @Autowired
    private InventoryService service;

    @RequestMapping("/demo")
    public ResponseEntity<String> demo() {
        if (featureManager.isActive(NEW_PRODUCT)) {
            log.info("new product feature enabled");
        } else {
            log.info("running the old code");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/orders")
    public List<Order> showAvailableProducts() {
        if (!featureManager.isActive(DISCOUNT_APPLIED)) {
            return service.getOrders();
        } else {
            //apply discount and return list of orders
            List<Order> orderListAfterDiscount = new ArrayList<>();
            service.getOrders().forEach(order -> {
                order.setPrice(order.getPrice() - (order.getPrice() * 5 / 100));
                orderListAfterDiscount.add(order);
            });
            return orderListAfterDiscount;
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(SwitchFeatureApplication.class, args);
    }


}
