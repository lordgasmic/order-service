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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
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
        final List<OrderEntity> orders = orderRepository.findAll();

        final List<Long> orderIds = orders.stream().map(OrderEntity::getId).toList();
        final List<OrderItemEntity> orderItems = orderItemRepository.findByOrderIdIn(orderIds);

        final List<Long> orderItemIds = orderItems.stream().map(OrderItemEntity::getId).toList();
        final List<OrderExtrasEntity> orderExtras = orderEntityRepository.findByOrderItemIdIn(orderItemIds);


        final List<OrderResponse> responses = new ArrayList<>();
        for (final OrderEntity order : orders) {
            final OrderResponse response = OrderMapper.toOrderResponse(order);

            final Map<String, List<String>> items = new HashMap<>();
            // iterate over items to get items that match order
            for (final OrderItemEntity orderItem : orderItems) {
                if (order.getId() == orderItem.getOrderId()) {
                    final List<String> extrasList = new ArrayList<>();

                    for (final OrderExtrasEntity extras : orderExtras) {
                        if (orderItem.getId() == extras.getOrderItemId()) {
                            extrasList.add(extras.getExtra());
                        }
                    }

                    items.put(orderItem.getItem(), extrasList);
                }
            }
            response.setItems(items);

            responses.add(response);
        }

        return responses;
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
