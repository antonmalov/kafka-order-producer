package org.example.orderservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.example.dto.OrderRequest;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderRequest> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderRequest order) {
        kafkaTemplate.send("orders-v2", order.getOrderId(), order);
    }
}
