package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Referencer;
import com.renangmarques.inhistory.service.ReferencerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/referencers")
public class ReferencerController {

    private final ReferencerService referencerService;

    @GetMapping("/all")
    public Collection<Referencer> findAll() {
        return referencerService.findAll();
    }

}
