package com.beyonder.bookservice.service.implementation;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.repository.BookRepository;
import com.beyonder.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getById(Long id) {
        return bookRepository.findById(id).get();
    }
}
