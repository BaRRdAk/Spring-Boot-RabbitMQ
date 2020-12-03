package ru.barrdak.amqp.services;

import ru.barrdak.amqp.domain.Message;

public interface MessageSender {
    void sendTopicMessage(Message message);
    void sendFanoutMessage(String message);
}
