package com.microservices.springkafkaproducer.controller;

import com.microservices.springkafkaproducer.bean.Order;
import com.microservices.springkafkaproducer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    public Order createOrder(@RequestBody Order order) {

        order=orderService.createOrder(order);
        return order;
    }

    @GetMapping("/all")
    public List<Order> getOrders() {
        return orderService.getAllOrders();

    }
}

