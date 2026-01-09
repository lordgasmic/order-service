package com.lordgasmic.orderingservice.mappers;

import com.lordgasmic.orderingservice.entities.OrderExtrasEntity;
import com.lordgasmic.orderingservice.entities.OrderItemEntity;
import com.lordgasmic.orderingservice.models.OrderExtra;
import com.lordgasmic.orderingservice.models.OrderRequest;

import java.util.ArrayList;
import java.util.List;

public class OrderExtrasMapper {

    public static Iterable<OrderExtrasEntity> toOrderExtrasEntities(OrderRequest request, Iterable<OrderItemEntity> items) {
        List<OrderExtrasEntity> entities = new ArrayList<>();

        for (OrderItemEntity item : items) {
            List<OrderExtra> extras = request.getProperties().get(item.getItem());
            if (extras == null || extras.isEmpty()) {
                continue;
            }

            for (OrderExtra extra : extras) {
                OrderExtrasEntity extrasEntity = new OrderExtrasEntity();
                extrasEntity.setOrderItemId(item.getId());
                extrasEntity.setExtra(extra.getExtra());
                extrasEntity.setType(extra.getType());
                entities.add(extrasEntity);
            }
        }

        return entities;
    }
}
