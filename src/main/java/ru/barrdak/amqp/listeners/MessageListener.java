package ru.barrdak.amqp.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import ru.barrdak.amqp.domain.Message;

@Component
public class MessageListener {

    static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    //@RabbitListener(queues = "${test.amqp.topic.queue}")
    public void process(Message message){
        logger.info("Receiving a message:" + message.toString());
        logger.info("-------------------");
    }

    @RabbitListener(queues = "#{fanoutQueue_01.name}")
    public void fanoutListener_01(String in) {
        logger.info("Receiving fanout 01:" + in);
    }

    @RabbitListener(queues = "#{fanoutQueue_02.name}")
    public void fanoutListener_02(String in) throws InterruptedException {
        logger.info("Receiving fanout 02:" + in);
        StopWatch watch = new StopWatch();
        watch.start();
        Thread.sleep(1000);
        watch.stop();
    }

}
