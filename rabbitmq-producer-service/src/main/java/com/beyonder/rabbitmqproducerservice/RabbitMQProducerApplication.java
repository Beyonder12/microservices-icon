package com.beyonder.rabbitmqproducerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RabbitMQProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication.class, args);
    }

}
