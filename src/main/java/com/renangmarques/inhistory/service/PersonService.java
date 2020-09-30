package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Person;
import com.renangmarques.inhistory.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public Collection<Person> findAll() {
        return Lists.newArrayList(personRepository.findAll());
    }

}
