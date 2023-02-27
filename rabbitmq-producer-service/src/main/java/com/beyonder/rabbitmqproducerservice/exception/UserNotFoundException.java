package com.beyonder.rabbitmqproducerservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class UserNotFoundException extends RuntimeException{
    public String msg;
}
