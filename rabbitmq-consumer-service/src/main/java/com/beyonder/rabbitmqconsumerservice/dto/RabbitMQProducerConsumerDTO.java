package com.beyonder.rabbitmqconsumerservice.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RabbitMQProducerConsumerDTO implements Serializable {
    private Long id;
    private String name;

}
