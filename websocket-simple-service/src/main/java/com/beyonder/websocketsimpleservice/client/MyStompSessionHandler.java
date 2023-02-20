package com.beyonder.websocketsimpleservice.client;

import com.beyonder.websocketsimpleservice.model.Message;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

public class MyStompSessionHandler implements StompSessionHandler {
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/topic/messages", this);

        session.send("/app/chat", getSampleMessage());

        System.out.println("message sent to websocket server");
    }

    private Message getSampleMessage() {
        Message msg = new Message("message from client");
        return msg;
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        System.err.println(exception.getMessage());
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        System.err.println(exception.getMessage());
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Message.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Message msg = (Message) payload;

        System.out.println("response from server");

        System.out.println(msg.getContent());
    }
}
