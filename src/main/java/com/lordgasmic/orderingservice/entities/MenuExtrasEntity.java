package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "menu_extras_vw")
public class MenuExtrasEntity {

    @Id
    private long id;

    @Column(name = "menu_id")
    private long menuId;

    private String extra;
}
