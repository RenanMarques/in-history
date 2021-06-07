package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Book;
import com.renangmarques.inhistory.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public Collection<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping("/save")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

}
