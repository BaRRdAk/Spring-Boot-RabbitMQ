package ru.barrdak.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {

  private static final Logger log = LoggerFactory.getLogger(TestProducer.class);
  private RabbitTemplate template;

  public TestProducer(RabbitTemplate template){
    this.template = template;
  }

  public void sendTo(String queue, String message){
    this.template.convertAndSend(queue, message);
    log.info("Producer> Message Sent");
  }

}
