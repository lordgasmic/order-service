package com.lordgasmic.orderingservice.repository;

import com.lordgasmic.orderingservice.entities.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {

    List<OrderItemEntity> findByOrderIdIn(List<Long> orderIds);
}
