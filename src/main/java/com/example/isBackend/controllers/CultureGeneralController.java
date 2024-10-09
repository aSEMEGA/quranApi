package com.example.isBackend.controllers;

import com.example.isBackend.models.CultureGenerale;
import com.example.isBackend.services.CultureGeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("//cultureGeneral")
@RequiredArgsConstructor
public class CultureGeneralController {

    private final CultureGeneralService cultureGeneralService;

    @GetMapping("readAll")
    public List<CultureGenerale> getCultureArticles() {
        return cultureGeneralService.getCultureArticles();
    }

    @GetMapping("/{id}")
    public CultureGenerale getCultureArticleById(@PathVariable Long id) {
        return cultureGeneralService.getCultureArticleById(id);
    }
}
