package com.example.isBackend.controllers;

import com.example.isBackend.models.Jurisprudence;
import com.example.isBackend.services.JurisprudenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jurisprudence")
@RequiredArgsConstructor
public class JurisprudenceController {

    private final JurisprudenceService jurisprudenceService;

    @GetMapping("readAll")
    public List<Jurisprudence> getJurisprudences() {
        return jurisprudenceService.getJurisprudences();
    }

    @GetMapping("/{id}")
    public Jurisprudence getJurisprudenceById(@PathVariable Long id) {
        return jurisprudenceService.getJurisprudenceById(id);
    }
}
