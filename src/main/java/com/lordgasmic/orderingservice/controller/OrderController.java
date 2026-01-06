package com.lordgasmic.orderingservice.controller;

import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.OrderResponse;
import com.lordgasmic.orderingservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/api/v1/orders")
    public ResponseEntity<List<OrderResponse>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PutMapping("/api/v1/orders")
    public ResponseEntity<Void> putOrder(@RequestBody final OrderRequest order) {
        orderService.putOrder(order);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/api/v1/orders/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable final long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
