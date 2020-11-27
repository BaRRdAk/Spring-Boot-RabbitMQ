package ru.barrdak.amqp.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.barrdak.amqp.configurations.RabbitConfig;
import ru.barrdak.amqp.domain.Message;

@Component
public class MessageListener {

    static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void process(Message message){
        logger.info("Receiving a message:" + message.toString());
    }

}
