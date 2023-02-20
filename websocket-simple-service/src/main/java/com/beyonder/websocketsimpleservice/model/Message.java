package com.beyonder.websocketsimpleservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty
    private String content;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
