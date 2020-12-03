package ru.barrdak.amqp.services.defaultImpl;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.barrdak.amqp.configurations.RabbitConfig;
import ru.barrdak.amqp.domain.Message;
import ru.barrdak.amqp.services.MessageSender;

@Service("default")
public class MessageSenderImpl implements MessageSender {

    @Autowired
    Queue topicOrdersQueue;

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendTopicMessage(Message message) {
        this.rabbitTemplate.convertAndSend(topicOrdersQueue.getName(), message);
    }

    @Override
    public void sendFanoutMessage(String message) {
        this.rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
    }

}
