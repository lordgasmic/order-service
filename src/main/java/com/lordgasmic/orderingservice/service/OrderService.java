package com.lordgasmic.orderingservice.service;

import com.lordgasmic.orderingservice.entities.OrderEntity;
import com.lordgasmic.orderingservice.mappers.OrderMapper;
import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.OrderResponse;
import com.lordgasmic.orderingservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getOrders() {
        final Iterable<OrderEntity> orders = orderRepository.findAll();

        final List<OrderResponse> response = new ArrayList<>();
        for (final OrderEntity order : orders) {
            response.add(OrderMapper.toOrderResponse(order));
        }

        return response;
    }


    public void putOrder(final OrderRequest request) {
        final OrderEntity entity = OrderMapper.toOrderEntity(request);
        orderRepository.save(entity);
    }

    public OrderResponse getOrderById(final long id) {
        final Optional<OrderEntity> entity = orderRepository.findById(id);
        return entity.map(OrderMapper::toOrderResponse).orElse(null);
    }
}
