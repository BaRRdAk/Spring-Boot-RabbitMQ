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

  public static final String EXCHANGE_ORDERS = "orders-exchange";

  // Очередь задач
  public static final String QUEUE_ORDERS = "orders-queue";

  @Bean
  Queue ordersQueue() {
    return QueueBuilder.durable(QUEUE_ORDERS).build();
  }

  @Bean
  Exchange ordersExchange() {
    return ExchangeBuilder.topicExchange(EXCHANGE_ORDERS).build();
  }

  @Bean
  Binding binding(Queue ordersQueue, TopicExchange ordersExchange) {
    return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(QUEUE_ORDERS);
  }

}
