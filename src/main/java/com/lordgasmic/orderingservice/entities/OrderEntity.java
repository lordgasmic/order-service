package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_vw")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String user;

    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;
}
