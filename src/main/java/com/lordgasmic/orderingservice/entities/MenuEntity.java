package com.lordgasmic.orderingservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "menu_vw")
public class MenuEntity {

    @Id
    @GeneratedValue
    private long id;

    private String item;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private List<MenuExtrasEntity> extras;
}
