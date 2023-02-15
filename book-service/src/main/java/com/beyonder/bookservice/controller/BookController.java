package com.beyonder.bookservice.controller;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookEntity> getAll() {
        int a = 1;
        log.info("Class BookController method getAll...{}", a);
//        log.debug("Debug here...");
//        log.warn("Warning...");
//        log.error("error");
        log.trace("trace");

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
