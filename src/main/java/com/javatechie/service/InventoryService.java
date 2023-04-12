package com.javatechie.service;

import com.javatechie.dto.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InventoryService {

    public List<Order> getOrders() {
        return Stream.of(new Order(1, "mobile", 50000),
                new Order(2, "headphone", 2000),
                new Order(3, "watch", 14999)
                , new Order(4, "glass", 999)
        ).collect(Collectors.toList());
    }
}
