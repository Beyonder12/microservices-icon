package com.beyonder.rabbitmqproducerservice.controller;

import com.beyonder.rabbitmqproducerservice.config.RabbitProducerConfig;
import com.beyonder.rabbitmqproducerservice.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rabbitmq-producer")
@RequiredArgsConstructor
@Slf4j
public class RabitMQProducerController {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send-data")
    public ResponseEntity<ResponseDTO> sendDataFromProducer(@RequestBody RabbitMQProducerConsumerDTO rabbitMQProducerConsumerDTO) {
        log.info("Data will be sent, the data : {}", rabbitMQProducerConsumerDTO);
        rabbitTemplate.convertAndSend(RabbitProducerConfig.EXCHANGE, RabbitProducerConfig.ROUTING_KEY, rabbitMQProducerConsumerDTO);
        log.info("Data has been sent");
        return new ResponseEntity<>(ResponseDTO.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("data is created")
                .build(), HttpStatus.CREATED);
    }

}
