package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "order_vw")
public class OrderEntity {

    @Id
    private long id;

    private String user;

    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> items;
}
