package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_extras_vw")
public class OrderExtrasEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "order_item_id")
    private long orderItemId;

    private String extra;

    private String type;
}
