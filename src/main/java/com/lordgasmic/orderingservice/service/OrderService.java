package com.lordgasmic.orderingservice.service;

import com.lordgasmic.orderingservice.entities.OrderEntity;
import com.lordgasmic.orderingservice.entities.OrderExtrasEntity;
import com.lordgasmic.orderingservice.entities.OrderItemEntity;
import com.lordgasmic.orderingservice.mappers.OrderExtrasMapper;
import com.lordgasmic.orderingservice.mappers.OrderItemMapper;
import com.lordgasmic.orderingservice.mappers.OrderMapper;
import com.lordgasmic.orderingservice.mappers.PrintMapper;
import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.OrderResponse;
import com.lordgasmic.orderingservice.models.PrintRequest;
import com.lordgasmic.orderingservice.repository.OrderExtrasRepository;
import com.lordgasmic.orderingservice.repository.OrderItemRepository;
import com.lordgasmic.orderingservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PrintAdapter printAdapter;
    private final OrderItemRepository orderItemRepository;
    private final OrderExtrasRepository orderEntityRepository;

    public OrderService(final OrderRepository orderRepository, final PrintAdapter printAdapter, final OrderItemRepository orderItemRepository, final OrderExtrasRepository orderEntityRepository) {
        this.orderRepository = orderRepository;
        this.printAdapter = printAdapter;
        this.orderItemRepository = orderItemRepository;
        this.orderEntityRepository = orderEntityRepository;
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
        final PrintRequest printRequest = PrintMapper.toPrintRequest(request);
        printAdapter.send(printRequest);

        // write history
        OrderEntity entity = OrderMapper.toOrderEntity(request);
        entity = orderRepository.save(entity);

        Iterable<OrderItemEntity> orderItemEntities = OrderItemMapper.toOrderItemEntity(request, entity.getId());
        orderItemEntities = orderItemRepository.saveAll(orderItemEntities);

        final Iterable<OrderExtrasEntity> orderExtrasEntities = OrderExtrasMapper.toOrderExtrasEntities(request, orderItemEntities);
        orderEntityRepository.saveAll(orderExtrasEntities);
    }

    public OrderResponse getOrderById(final long id) {
        final Optional<OrderEntity> entity = orderRepository.findById(id);
        return entity.map(OrderMapper::toOrderResponse).orElse(null);
    }
}
