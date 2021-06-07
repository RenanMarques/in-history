package com.renangmarques.inhistory.service;

import com.google.common.collect.Lists;
import com.renangmarques.inhistory.model.Movie;
import com.renangmarques.inhistory.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public Collection<Movie> findAll() {
        return Lists.newArrayList(movieRepository.findAll());
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

}
