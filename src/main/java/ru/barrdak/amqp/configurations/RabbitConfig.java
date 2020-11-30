package ru.barrdak.amqp.configurations;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
public class RabbitConfig {

  @Bean
  Queue ordersQueue(@Value("${test.amqp.queue}") String queue) {
    return QueueBuilder.durable(queue).build();
  }

  @Bean
  Exchange ordersExchange(@Value("${test.amqp.exchange}") String exchange) {
    return ExchangeBuilder.topicExchange(exchange).build();
  }

  @Bean
  Binding binding(Queue ordersQueue, TopicExchange ordersExchange) {
    return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(ordersQueue.getName());
  }

}
