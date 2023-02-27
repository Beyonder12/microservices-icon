package com.beyonder.rabbitmqconsumerservice.exception;

import com.beyonder.rabbitmqconsumerservice.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LessonGlobalException {

    @ExceptionHandler(value = LessonNotFoundException.class)
    public ResponseEntity<ResponseDTO<Object>> globalException(LessonNotFoundException e) {
        return new ResponseEntity<>(ResponseDTO.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message("Not Found")
                .data(e.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDTO<Object>> globalException(Exception e) {
        return new ResponseEntity<>(ResponseDTO.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("Bad Request")
                .data(e.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

}
