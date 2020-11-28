package ru.barrdak.amqp.services;

import ru.barrdak.amqp.domain.Message;

public interface MessageSender {
    void sendMessage(Message message);
}
