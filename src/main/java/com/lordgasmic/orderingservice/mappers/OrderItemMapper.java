package com.lordgasmic.orderingservice.mappers;

import com.lordgasmic.orderingservice.entities.OrderItemEntity;
import com.lordgasmic.orderingservice.models.OrderRequest;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {

    public static List<OrderItemEntity> toOrderItemEntity(final OrderRequest request, final long id) {
        final List<OrderItemEntity> entities = new ArrayList<>();

        for (final String key : request.getProperties().keySet()) {
            final OrderItemEntity entity = new OrderItemEntity();
            entity.setOrderId(id);
            entity.setItem(key);
            entities.add(entity);
        }
        return entities;
    }
}
