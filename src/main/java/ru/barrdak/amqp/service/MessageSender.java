package ru.barrdak.amqp.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barrdak.amqp.configurations.RabbitConfig;
import ru.barrdak.amqp.domain.Message;

@Service
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Message message) {

        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, message);

    }

}
