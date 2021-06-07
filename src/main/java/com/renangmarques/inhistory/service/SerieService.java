package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Serie;
import com.renangmarques.inhistory.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public Collection<Serie> findAll() {
        return Lists.newArrayList(serieRepository.findAll());
    }

    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

}
