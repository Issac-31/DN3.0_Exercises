package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.BookDTO;
import com.example.BookstoreAPI.mapper.BookMapper;
import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toBook(bookDTO);
        book = bookRepository.save(book);
        return BookMapper.INSTANCE.toBookDTO(book);
    }

    // Read All
    @GetMapping
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper.INSTANCE::toBookDTO)
                .collect(Collectors.toList());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        return bookRepository.findById(id)
                .map(book -> ResponseEntity.ok(BookMapper.INSTANCE.toBookDTO(book)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @Valid @RequestBody BookDTO bookDTO) {
        return bookRepository.findById(id)
                .map(book -> {
                    Book updatedBook = BookMapper.INSTANCE.toBook(bookDTO);
                    updatedBook.setId(book.getId());  // Ensure ID is the same
                    updatedBook.setVersion(book.getVersion());  // Ensure version is the same
                    bookRepository.save(updatedBook);
                    return ResponseEntity.ok(BookMapper.INSTANCE.toBookDTO(updatedBook));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
