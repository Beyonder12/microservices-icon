package com.beyonder.bookservice.controller;

import com.beyonder.bookservice.dto.Message;
import com.beyonder.bookservice.dto.MessageResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class WebSocketController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageResponse send(Message message) {
        return new MessageResponse("Hello, " + message.getName() + "!");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
