package com.lordgasmic.orderingservice.service;

import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class PrintService {

    @Value("${lordgasmic.rabbitmq.exchange}")
    private String exchange;

    @Value("${lordgasmic.rabbitmq.routingKey}")
    private String routingKey;

    private final AmqpTemplate amqpTemplate;
    private final Gson gson;

    public PrintService(final AmqpTemplate amqpTemplate, final Gson gson) {
        this.amqpTemplate = amqpTemplate;
        this.gson = gson;
    }

    public void send(final OrderingRequest request) {
        final Message message = new Message(gson.toJson(request).getBytes(StandardCharsets.UTF_8));
        amqpTemplate.send(exchange, routingKey, message);
        log.info("LGC:d6d65ca6-88fe-4c06-9521-cfbf3e10d561 - Sent order");
    }
}
