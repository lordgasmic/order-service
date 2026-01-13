package com.lordgasmic.orderingservice.repository;

import com.lordgasmic.orderingservice.entities.OrderExtrasEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderExtrasRepository extends CrudRepository<OrderExtrasEntity, Long> {

    List<OrderExtrasEntity> findByOrderItemIdIn(List<Long> orderItemIds);
}
