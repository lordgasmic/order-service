package com.lordgasmic.orderingservice.repository;

import com.lordgasmic.orderingservice.entities.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {
}
