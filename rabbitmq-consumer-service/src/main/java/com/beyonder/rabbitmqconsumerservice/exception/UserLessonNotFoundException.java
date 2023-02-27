package com.beyonder.rabbitmqconsumerservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class UserLessonNotFoundException extends RuntimeException{
    public String msg;
}
