package com.alopez.orderservice.controller;

import com.alopez.basedomains.dto.Order;
import com.alopez.basedomains.dto.OrderEvent;
import com.alopez.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());

        OrderEvent orderEvent = OrderEvent.builder()
                .status("PENDING")
                .message("order is in pending status")
                .order(order)
                .build();

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully";
    }
}
