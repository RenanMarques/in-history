package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Serie;
import com.renangmarques.inhistory.service.SerieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/series")
public class SerieController {

    private final SerieService serieService;

    @GetMapping("/all")
    public Collection<Serie> findAll() {
        return serieService.findAll();
    }

}
