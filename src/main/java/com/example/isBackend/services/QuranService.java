package com.example.isBackend.services;

import com.example.isBackend.models.Ayat;
import com.example.isBackend.models.Surah;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuranService {

    private final RestTemplate restTemplate;

    @Value("${external.api.quran.url}")
    private String quranApiUrl;

    public List<Surah> getAllSurah() {
        Surah[] surah = restTemplate.getForObject(quranApiUrl + "/surah/", Surah[].class);
        return List.of(surah);
    }

    public List<Ayat> getAyahsBySurahId(Long id){
        Ayat[] ayats = restTemplate.getForObject(quranApiUrl + "/surah/" + id + "/ayah/", Ayat[].class);
        return List.of(ayats);
    }

    public String getAudioForAyah(Long ayatId, Long reciterId){
        return restTemplate.getForObject(quranApiUrl + "/audio/" + ayatId + "/" + reciterId, String.class);

    }
}
