package com.beyonder.bookservice.service.implementation;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    @Mock
    private BookRepository bookRepository;

    @Test
    void getAllTest(){
        //arrange
        BookEntity bookEntity1 = new BookEntity(1l, "physics", "fajri");
        BookEntity bookEntity2 = new BookEntity(2l, "mathematic", "joko");
        List<BookEntity> expected = List.of(bookEntity1, bookEntity2);
        //
        when(bookRepository.findAll()).thenReturn(expected);

        //assert
        List<BookEntity> actual = bookServiceImpl.getAll();
        Assertions.assertEquals(expected, actual);

    }

}
