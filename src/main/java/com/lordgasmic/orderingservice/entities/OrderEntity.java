package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order_vw")
public class OrderEntity {

    @Id
    private long id;

    private String user;

    @Column(name = "created_at", insertable = false)
    private LocalDateTime createdAt;
}
