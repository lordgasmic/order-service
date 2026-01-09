package com.lordgasmic.orderingservice.repository;

import com.lordgasmic.orderingservice.entities.OrderExtrasEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderExtrasRepository extends CrudRepository<OrderExtrasEntity, Long> {
}
