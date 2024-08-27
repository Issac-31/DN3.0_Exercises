package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
        bookRepository.save(new Book(null, "Test Book", "Test Author", 19.99, "ISBN123"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'title':'Test Book','author':'Test Author','price':19.99,'isbn':'ISBN123'}]"));
    }

    @Test
    public void testCreateBook() throws Exception {
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Book\",\"author\":\"New Author\",\"price\":9.99,\"isbn\":\"ISBN456\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'title':'New Book','author':'New Author','price':9.99,'isbn':'ISBN456'}"));
    }
}
