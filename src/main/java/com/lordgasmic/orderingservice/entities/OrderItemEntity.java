package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "order_item_vw")
public class OrderItemEntity {

    @Id
    private long id;

    @Column(name = "order_id")
    private long orderId;

    private String item;
}
