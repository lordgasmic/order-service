package com.lordgasmic.orderingservice.mappers;

import com.lordgasmic.orderingservice.entities.OrderEntity;
import com.lordgasmic.orderingservice.entities.OrderExtrasEntity;
import com.lordgasmic.orderingservice.entities.OrderItemEntity;
import com.lordgasmic.orderingservice.models.OrderExtra;
import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.OrderResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapper {

    public static OrderResponse toOrderResponse(final OrderEntity entity) {
        final OrderResponse response = new OrderResponse();
        final Map<String, List<String>> items = new HashMap<>();
        response.setUser(entity.getUser());
        response.setOrderDate(entity.getCreatedAt());

        for (final OrderItemEntity item : entity.getItems()) {
            if (item.getExtras() != null && !item.getExtras().isEmpty()) {
                items.put(item.getItem(), item.getExtras().stream().map(OrderExtrasEntity::getExtra).toList());
            } else {
                items.put(item.getItem(), List.of());
            }
        }
        response.setItems(items);

        return response;
    }

    public static OrderEntity toOrderEntity(final OrderRequest request) {
        final OrderEntity entity = new OrderEntity();
        entity.setUser(request.getUser());

        for (final Map.Entry<String, List<OrderExtra>> entry : request.getItems().entrySet()) {
            final OrderItemEntity itemEntity = new OrderItemEntity();
            itemEntity.setItem(entry.getKey());
            itemEntity.setExtras(new ArrayList<>());

            for (final OrderExtra extra : entry.getValue()) {
                final OrderExtrasEntity extrasEntity = new OrderExtrasEntity();
                extrasEntity.setExtra(extra.getExtra());
                extrasEntity.setType(extra.getType());
                itemEntity.getExtras().add(extrasEntity);
            }

            entity.getItems().add(itemEntity);
        }

        return entity;
    }
}
