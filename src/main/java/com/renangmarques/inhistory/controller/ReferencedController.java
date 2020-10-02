package com.renangmarques.inhistory.controller;

import com.renangmarques.inhistory.model.Referenced;
import com.renangmarques.inhistory.service.ReferencedService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/referenceds")
public class ReferencedController {

    private final ReferencedService referencedService;

    @GetMapping("/all")
    public Collection<Referenced> findAll() {
        return referencedService.findAll();
    }

}
