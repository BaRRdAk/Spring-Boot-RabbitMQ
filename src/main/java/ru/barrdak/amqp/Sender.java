package ru.barrdak.amqp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Sender {

  @Bean
  public CommandLineRunner sendToDos(@Value("${test.amqp.queue}") String destination, TestProducer producer) {
    return args -> {
      producer.sendTo(destination, "workout tomorrow morning!");
    };
  }

}
