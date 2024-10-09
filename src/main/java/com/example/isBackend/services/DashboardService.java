package com.example.isBackend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private TajweedService tajweedService;


    private QuranService quranService;

    private HadithService hadithService;

    // Récupérer les statistiques du tableau de bord
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("tajweedLessons", tajweedService.getLessons().size());
        stats.put("quranSurahs", quranService.getAllSurah().size());
        stats.put("hadiths", hadithService.getHadiths().size());


        return stats;
    }
}
