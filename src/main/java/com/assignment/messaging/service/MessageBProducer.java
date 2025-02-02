package com.assignment.messaging.service;


import com.assignment.messaging.config.RabbitMqConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageBProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageBProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String produceMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.EXCHANGE_NAME, "myRoutingKey.#",
                message);
        return "Message(" + message + ")" + " has been produced.";
    }
}
