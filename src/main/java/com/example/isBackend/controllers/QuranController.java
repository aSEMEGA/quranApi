package com.example.isBackend.controllers;

import com.example.isBackend.models.Ayat;
import com.example.isBackend.models.Surah;
import com.example.isBackend.services.QuranService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quran")
@RequiredArgsConstructor
public class QuranController {

    private QuranService quranService;

    @GetMapping("/surah")
    public List<Surah> getSurahs() {
        return quranService.getAllSurah();
    }

    @GetMapping("/surah/{id}/ayah")
    public List<Ayat> getAyahsBySurahId(@PathVariable Long id) {
        return quranService.getAyahsBySurahId(id);
    }

    @GetMapping("/ayah/{ayahId}/audio/{reciterId}")
    public String getAudioForAyah(@PathVariable Long ayahId, @PathVariable Long reciterId) {
        return quranService.getAudioForAyah(ayahId, reciterId);
    }
}
