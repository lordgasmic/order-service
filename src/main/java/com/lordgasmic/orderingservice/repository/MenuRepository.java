package com.lordgasmic.orderingservice.repository;

import com.lordgasmic.orderingservice.entities.MenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<MenuEntity, Long> {
}
