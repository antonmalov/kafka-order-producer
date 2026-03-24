package org.example.orderservice.controller;


import org.example.orderservice.service.OrderProducer;
import org.springframework.web.bind.annotation.*;
import org.example.dto.OrderRequest;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderRequest order) {
        producer.sendOrder(order);
        return "Order sent";
    }
}
