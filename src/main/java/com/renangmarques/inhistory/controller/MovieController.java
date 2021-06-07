package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Movie;
import com.renangmarques.inhistory.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public Collection<Movie> findAll() {
        return movieService.findAll();
    }

    @PostMapping("/save")
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

}
