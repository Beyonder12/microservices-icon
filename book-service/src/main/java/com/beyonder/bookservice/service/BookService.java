package com.beyonder.bookservice.service;

import com.beyonder.bookservice.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<BookEntity> getAll() ;

    BookEntity getById(Long id);

    BookEntity create(BookEntity bookEntity);

    BookEntity update(BookEntity bookEntity, Long id);

    void deleteById(Long id);
}
