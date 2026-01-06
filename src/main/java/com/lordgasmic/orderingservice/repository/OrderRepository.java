package com.lordgasmic.orderingservice.repository;

import com.lordgasmic.orderingservice.entities.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
