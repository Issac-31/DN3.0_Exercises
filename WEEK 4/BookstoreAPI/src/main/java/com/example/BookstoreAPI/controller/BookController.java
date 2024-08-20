package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        if (title == null && author == null) {
            return books;
        }

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            boolean matches = true;
            if (title != null && !book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matches = false;
            }
            if (author != null && !book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                matches = false;
            }
            if (matches) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPrice(book.getPrice());
                b.setIsbn(book.getIsbn());
                return b;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
