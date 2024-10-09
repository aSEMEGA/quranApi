package com.example.isBackend.controllers;

import com.example.isBackend.models.Hadith;
import com.example.isBackend.services.HadithService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hadith")
@RequiredArgsConstructor
public class HadithController {

    private final HadithService hadithService;

    @GetMapping("readAll")
    public List<Hadith> getHadiths() {
        return hadithService.getHadiths();
    }

    @GetMapping("/{id}")
    public Hadith getHadithById(@PathVariable Long id) {
        return hadithService.getHadithById(id);
    }
}
