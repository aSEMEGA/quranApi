package com.example.isBackend.services;

import com.example.isBackend.models.TajweedLesson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TajweedService {

    private final RestTemplate restTemplate;

    @Value("${external.api.tajweed.url}")
    private String tajweedApiUrl;

    // Récupérer les leçons de Tajweed
    public List<TajweedLesson> getLessons() {
        TajweedLesson[] tajweedLessons = restTemplate.getForObject(tajweedApiUrl + "/lessons", TajweedLesson[].class);
        return List.of(tajweedLessons);
    }

    //Recuperer une leçon specifique
    public TajweedLesson getLessonById(Long id) {
        return restTemplate.getForObject(tajweedApiUrl + "/lessons/" + id, TajweedLesson.class);
    }
}
