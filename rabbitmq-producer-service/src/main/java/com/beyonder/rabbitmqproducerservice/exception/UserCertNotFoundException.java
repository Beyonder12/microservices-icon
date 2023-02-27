package com.beyonder.rabbitmqproducerservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCertNotFoundException extends RuntimeException{
    private String msg;
}
