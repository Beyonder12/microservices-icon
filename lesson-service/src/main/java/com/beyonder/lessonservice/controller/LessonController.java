package com.beyonder.lessonservice.controller;

import com.beyonder.lessonservice.model.BaseResponse;
import com.beyonder.lessonservice.model.Lesson;
import com.beyonder.lessonservice.model.LessonRequest;
import com.beyonder.lessonservice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonRepository lessonRepository;

    @GetMapping
    public BaseResponse<List<Lesson>> getAll() {
        List<Lesson> lessons = new ArrayList<>();

        lessonRepository.findAll().forEach(lessons::add);

        return new BaseResponse<>(
                "success",
                "all lessons",
                lessons
        );
    }

    @PostMapping
    public BaseResponse<Lesson> create(@RequestBody LessonRequest request) {
        UUID uuid = UUID.randomUUID();

        Lesson lesson = new Lesson(uuid.toString(), request.getMake(), request.getName());

        Lesson createdLesson = lessonRepository.save(lesson);

        return new BaseResponse<>(
                "success",
                "lesson created",
                createdLesson
        );
    }
}
