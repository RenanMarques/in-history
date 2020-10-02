package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Referencer;
import com.renangmarques.inhistory.repository.ReferencerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReferencerService {

    private final ReferencerRepository referencerRepository;

    public Collection<Referencer> findAll() {
        return Lists.newArrayList(referencerRepository.findAll());
    }

}
