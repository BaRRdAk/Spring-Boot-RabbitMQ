package ru.barrdak.amqp.shedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.barrdak.amqp.domain.Message;
import ru.barrdak.amqp.services.defaultImpl.MessageSenderImpl;

@Component
public class Task_01 {

    static final Logger logger = LoggerFactory.getLogger(Task_01.class);

    @Autowired
    private MessageSenderImpl messageSender;

    @Scheduled(fixedDelay = 3000)
    private void task_1(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMessage("Message text");
        messageSender.sendMessage(message);
        logger.info("Sending a message:" + message.toString());
    }

}
