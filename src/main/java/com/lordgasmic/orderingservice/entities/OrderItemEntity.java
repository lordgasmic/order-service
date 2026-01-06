package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id")
    private List<OrderExtrasEntity> extras;
}
