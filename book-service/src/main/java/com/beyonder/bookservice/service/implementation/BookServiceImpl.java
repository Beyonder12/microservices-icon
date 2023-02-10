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

    @Override
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity update(BookEntity bookEntity, Long id) {
        BookEntity bookEntity1 = bookRepository.findById(id).get();
        bookEntity1.setAuthor(bookEntity.getAuthor());
        bookEntity1.setName(bookEntity.getName());
        return bookRepository.save(bookEntity1);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
