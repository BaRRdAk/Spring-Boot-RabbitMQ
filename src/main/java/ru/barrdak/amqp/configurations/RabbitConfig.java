package ru.barrdak.amqp.configurations;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  @Bean
  Queue topicOrdersQueue(@Value("${test.amqp.topic.queue}") String queue) {
    return QueueBuilder.durable(queue).build();
  }

  @Bean
  TopicExchange topicExchange(@Value("${test.amqp.topic.exchange}") String exchange) {
    return ExchangeBuilder.topicExchange(exchange).build();
  }

  @Bean
  Binding topicBinding(TopicExchange topicExchange, Queue topicOrdersQueue) {
    return BindingBuilder.bind(topicOrdersQueue).to(topicExchange).with(topicOrdersQueue.getName());
  }



  @Bean
  DirectExchange directOrdersExchange(@Value("${test.amqp.direct.exchange}") String exchange) {
    return ExchangeBuilder.directExchange(exchange).build();
  }

  @Bean
  HeadersExchange headersOrdersExchange(@Value("${test.amqp.headers.exchange}") String exchange) {
    return ExchangeBuilder.headersExchange(exchange).build();
  }

  ////////////////////////////////////
  // Publish/Subscribe
  ////////////////////////////////////
  @Bean
  Queue fanoutQueue_01() {
    return new AnonymousQueue();
  }

  @Bean
  Queue fanoutQueue_02() {
    return new AnonymousQueue();
  }

  @Bean
  FanoutExchange fanoutExchange(@Value("${test.amqp.fanout.exchange}") String exchange) {
    return ExchangeBuilder.fanoutExchange(exchange).build();
  }

  @Bean
  Binding fanoutBinding_01(FanoutExchange fanoutExchange, Queue fanoutQueue_01) {
    return BindingBuilder.bind(fanoutQueue_01).to(fanoutExchange);
  }

  @Bean
  Binding fanoutBinding_02(FanoutExchange fanoutExchange, Queue fanoutQueue_02) {
    return BindingBuilder.bind(fanoutQueue_02).to(fanoutExchange);
  }


}
