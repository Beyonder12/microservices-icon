package com.beyonder.lessonservice.model;

public class LessonRequest {
    private String make;
    private String name;

    public LessonRequest(String make, String name) {
        this.make = make;
        this.name = name;
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
