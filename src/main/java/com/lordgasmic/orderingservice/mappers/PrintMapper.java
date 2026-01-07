package com.lordgasmic.orderingservice.mappers;

import com.lordgasmic.orderingservice.models.OrderExtra;
import com.lordgasmic.orderingservice.models.OrderRequest;
import com.lordgasmic.orderingservice.models.PrintRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintMapper {

    public static PrintRequest toPrintRequest(final OrderRequest orderRequest) {
        final PrintRequest printRequest = new PrintRequest();

        printRequest.setMessage(orderRequest.getMessage());
        printRequest.setType(orderRequest.getType());

        final Map<String, String[]> properties = new HashMap<>();
        for (final Map.Entry<String, List<OrderExtra>> entry : orderRequest.getItems().entrySet()) {
            properties.put(entry.getKey(), entry.getValue().stream().map(OrderExtra::getExtra).toArray(String[]::new));
        }
        printRequest.setProperties(properties);

        return printRequest;
    }
}
