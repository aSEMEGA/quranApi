package com.example.isBackend.controllers;

import com.example.isBackend.models.Tafsir;
import com.example.isBackend.services.TafsirService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tafsir")
@RequiredArgsConstructor
public class TafsirController {

    private final TafsirService tafsirService;

    @GetMapping("readAll")
    public List<Tafsir> getTafsirs() {
        return tafsirService.getTafsirs();
    }

    @GetMapping("/{id}")
    public Tafsir getTafsirById(@PathVariable Long id) {
        return tafsirService.getTafsirById(id);
    }
}
