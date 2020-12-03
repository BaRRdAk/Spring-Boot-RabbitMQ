package ru.barrdak.amqp.shedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.barrdak.amqp.domain.Message;
import ru.barrdak.amqp.services.defaultImpl.MessageSenderImpl;

@Component
public class RabbitTasks {

    static final Logger logger = LoggerFactory.getLogger(RabbitTasks.class);

    @Autowired
    private MessageSenderImpl messageSender;

    //@Scheduled(fixedDelay = 3000)
    private void task_to_topic(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMessage("Message to topic exchange");
        messageSender.sendTopicMessage(message);
        logger.info("Sending a message:" + message.toString());
    }

    @Scheduled(fixedDelay = 500)
    private void task_to_fanout(){
        String timestamp = Long.toString(System.currentTimeMillis());
        messageSender.sendFanoutMessage(timestamp);
        logger.info("Timestamp: " + timestamp);
    }

}
