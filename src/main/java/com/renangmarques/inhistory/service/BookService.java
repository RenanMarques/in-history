package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Book;
import com.renangmarques.inhistory.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Collection<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

}
