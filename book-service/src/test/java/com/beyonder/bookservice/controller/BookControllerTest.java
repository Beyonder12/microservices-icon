package com.beyonder.bookservice.controller;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;
    @BeforeEach
    public void setup() {

        mockMvc = standaloneSetup(bookController).build();
    }
    @Test
    void testGetAll() throws Exception {
        //arrange
        BookEntity bookEntity1 = new BookEntity(1l, "Physics", "Fajri");
        BookEntity bookEntity2 = new BookEntity(2l, "Clean Code", "Bob");
        List<BookEntity> bookEntityList = List.of(bookEntity1, bookEntity2);

        //act/invoke
        when(bookService.getAll()).thenReturn(bookEntityList);

        //assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"name\":\"Physics\",\"author\":\"Fajri\"},{\"id\":2,\"name\":\"Clean Code\",\"author\":\"Bob\"}]"));
    }

    @Test
    void testGetUserById() throws Exception {

        BookEntity bookEntity = new BookEntity(1L, "John Doe", "john.doe@example.com");
        when(bookService.getById(1L)).thenReturn(bookEntity);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("john.doe@example.com"));
    }
    @Test
    public void testCreate() throws Exception {
        String bookJson = "{\"name\": \"John Doe\", \"author\": \"john.doe@example.com\"}";

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("John Doe");
        bookEntity.setAuthor("john.doe@example.com");
        BookEntity bookEntity1 = new BookEntity(1l, "John Doe", "john.doe@example.com");

        when(bookService.create(bookEntity)).thenReturn(bookEntity1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void testUpdateUser() throws Exception {
        String userJson = "{\"name\": \"John Doe\", \"author\": \"john.doe@example.com\"}";

        BookEntity bookEntity1 = new BookEntity(1l, "John Doe", "john.doe@example.com");
        when(bookService.update(any(), any())).thenReturn(bookEntity1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/books/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("john.doe@example.com"));
    }

    @Test
    public void testDeleteUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/books/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
