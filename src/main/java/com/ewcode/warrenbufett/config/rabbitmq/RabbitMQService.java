package com.ewcode.warrenbufett.config.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    private static final String EXCHANGE = "";

    private final AmqpTemplate rabbitTemplate;

    public RabbitMQService(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String queue, String payload) {
        rabbitTemplate.convertAndSend(EXCHANGE, queue, payload);
    }
}