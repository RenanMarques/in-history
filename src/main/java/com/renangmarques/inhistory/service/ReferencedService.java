package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Referenced;
import com.renangmarques.inhistory.repository.ReferencedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReferencedService {

    private final ReferencedRepository referencedRepository;

    public Collection<Referenced> findAll() {
        return Lists.newArrayList(referencedRepository.findAll());
    }

}
