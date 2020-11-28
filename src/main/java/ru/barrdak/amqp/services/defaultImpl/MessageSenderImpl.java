package ru.barrdak.amqp.services.defaultImpl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barrdak.amqp.configurations.RabbitConfig;
import ru.barrdak.amqp.domain.Message;
import ru.barrdak.amqp.services.MessageSender;

@Service("default")
public class MessageSenderImpl implements MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Message message) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, message);
    }
}
