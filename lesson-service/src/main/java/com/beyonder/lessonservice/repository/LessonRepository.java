package com.beyonder.lessonservice.repository;

import com.beyonder.lessonservice.model.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String> {
}
