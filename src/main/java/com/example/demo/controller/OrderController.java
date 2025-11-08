package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public Order createOrder(@PathVariable String userId, @RequestBody Order order) {
        return service.createOrder(userId, order);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable String userId) {
        return service.getOrdersByUserId(userId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }
}
