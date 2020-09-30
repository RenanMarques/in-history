package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Person;
import com.renangmarques.inhistory.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/people")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/all")
    public Collection<Person> findAll() {
        return personService.findAll();
    }

}
