package com.lordgasmic.orderingservice.models;

import lombok.Data;

import java.util.Map;

@Data
public class PrintRequest {

    private String message;
    private String type;
    private Map<String, String[]> properties;
}
