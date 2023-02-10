package com.beyonder.bookservice.controller;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public BookEntity create(@RequestBody BookEntity bookEntity) {
        return bookService.create(bookEntity);
    }

    @PutMapping("/{id}")
    public BookEntity update(@RequestBody BookEntity bookEntity, @PathVariable Long id) {
        return bookService.update(bookEntity, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return "Successfully deleted!";
    }
}
