package com.example.isBackend.controllers;

import com.example.isBackend.models.TajweedLesson;
import com.example.isBackend.services.TajweedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tajweed")
@RequiredArgsConstructor
public class TajweedController {

    private final TajweedService tajweedService;

    @GetMapping("/lessons")
    public List<TajweedLesson> getLessons() {
        return tajweedService.getLessons();
    }

    @GetMapping("/lessons/{id}")
    public TajweedLesson getLessonById(@PathVariable Long id) {
        return tajweedService.getLessonById(id);
    }
}
