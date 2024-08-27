package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Book;
import com.example.BookstoreAPI.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = Arrays.asList(
                new Book(1L, "Book One", "Author One", 20.99, "ISBN001"),
                new Book(2L, "Book Two", "Author Two", 15.99, "ISBN002")
        );

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"title\":\"Book One\",\"author\":\"Author One\",\"price\":20.99,\"isbn\":\"ISBN001\"},{\"id\":2,\"title\":\"Book Two\",\"author\":\"Author Two\",\"price\":15.99,\"isbn\":\"ISBN002\"}]"));
    }

    @Test
    public void testCreateBook() throws Exception {
        Book newBook = new Book(null, "New Book", "New Author", 12.99, "ISBN003");
        Book savedBook = new Book(3L, "New Book", "New Author", 12.99, "ISBN003");

        when(bookService.createBook(newBook)).thenReturn(savedBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"New Book\",\"author\":\"New Author\",\"price\":12.99,\"isbn\":\"ISBN003\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"id\":3,\"title\":\"New Book\",\"author\":\"New Author\",\"price\":12.99,\"isbn\":\"ISBN003\"}"));
    }
}
