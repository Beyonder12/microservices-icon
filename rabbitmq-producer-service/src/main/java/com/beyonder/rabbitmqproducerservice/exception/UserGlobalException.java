package com.beyonder.rabbitmqproducerservice.exception;

import com.beyonder.rabbitmqproducerservice.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalException {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ResponseDTO<Object>> globalException(UserNotFoundException e) {
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
