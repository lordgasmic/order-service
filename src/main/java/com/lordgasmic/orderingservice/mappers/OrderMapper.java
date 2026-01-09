package com.lordgasmic.orderingservice.mappers;

import com.lordgasmic.orderingservice.entities.OrderEntity;
import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.OrderResponse;

public class OrderMapper {

    public static OrderResponse toOrderResponse(final OrderEntity entity) {
        final OrderResponse response = new OrderResponse();
        response.setUser(entity.getUser());
        response.setOrderDate(entity.getCreatedAt());

        return response;
    }

    public static OrderEntity toOrderEntity(final OrderRequest request) {
        final OrderEntity entity = new OrderEntity();
        entity.setUser(request.getUser());

        return entity;
    }
}
