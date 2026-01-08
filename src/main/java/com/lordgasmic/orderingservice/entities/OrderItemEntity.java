package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "order_item_vw")
public class OrderItemEntity {

    @Id
    private long id;

    @Column(name = "order_id")
    private long orderId;

    private String item;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_item_id")
    private List<OrderExtrasEntity> extras;
}
