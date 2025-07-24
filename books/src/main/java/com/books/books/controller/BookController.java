package com.books.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.books.books.repository.BookRepository;
import com.books.books.model.Book;
import com.books.books.dto.BookRequestDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // @PostMapping
    // public Book addBook(@RequestBody Book book) {
    //     return bookRepository.save(book);
    // }

    @PostMapping
    public ResponseEntity<?> addBook(@Valid @RequestBody BookRequestDto bookDto) {
        Book book = new Book(bookDto.getTitle(), bookDto.getAuthor());
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
