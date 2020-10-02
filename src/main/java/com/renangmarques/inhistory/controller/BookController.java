package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Book;
import com.renangmarques.inhistory.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
