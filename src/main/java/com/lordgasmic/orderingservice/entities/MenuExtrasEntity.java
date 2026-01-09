package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menu_extras_vw")
public class MenuExtrasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "menu_id")
    private long menuId;

    private String extra;
}
