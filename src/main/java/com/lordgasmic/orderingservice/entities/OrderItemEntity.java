package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_item_vw")
public class OrderItemEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "order_id")
    private long orderId;

    private String item;
}
