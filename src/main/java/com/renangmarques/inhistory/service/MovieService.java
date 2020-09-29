package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Movie;
import com.renangmarques.inhistory.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public Collection<Movie> findAll() {
        return Lists.newArrayList(movieRepository.findAll());
    }

}
