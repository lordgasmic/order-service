package com.lordgasmic.orderingservice.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderRequest {

    private String user;
    private Map<String, List<OrderExtra>> items;
}
