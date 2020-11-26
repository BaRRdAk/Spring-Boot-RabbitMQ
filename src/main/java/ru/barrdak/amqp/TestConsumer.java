package ru.barrdak.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {

  private Logger log = LoggerFactory.getLogger(TestConsumer.class);

  @RabbitListener(queues = "${test.amqp.queue}")
  public void processToDo(String message){
    log.info("Consumer> " + message);
  }

}
