package com.lordgasmic.orderingservice.models;

import lombok.Data;

import java.util.List;

@Data
public class MenuResponse {

    private String option;
    private List<String> extras;
}
