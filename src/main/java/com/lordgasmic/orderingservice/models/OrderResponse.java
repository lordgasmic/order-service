package com.lordgasmic.orderingservice.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class OrderResponse {

    private String user;
    private LocalDateTime orderDate;
    private Map<String, List<String>> items;
}
