package com.beyonder.bookservice.controller;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookEntity> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookEntity getById(@PathVariable Long id) {
        return bookService.getById(id);
    }
}
