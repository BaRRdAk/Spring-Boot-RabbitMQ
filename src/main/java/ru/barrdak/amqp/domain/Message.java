package ru.barrdak.amqp.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    private Long id;
    private String message;
}
