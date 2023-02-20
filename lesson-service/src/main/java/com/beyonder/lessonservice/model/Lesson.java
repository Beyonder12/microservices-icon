package com.beyonder.lessonservice.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Lesson")
public class Lesson {
    private String id;
    private String make;

    private String name;

    public Lesson(String id, String make, String name) {
        this.id = id;
        this.make = make;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
