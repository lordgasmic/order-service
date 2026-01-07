package com.lordgasmic.orderingservice.controller;

import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.OrderResponse;
import com.lordgasmic.orderingservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
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
        log.info("LGC-0802f4ad-36db-4b68-be22-35c01b5ccb41: order: {}", order);
        orderService.putOrder(order);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/api/v1/orders/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable final long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
