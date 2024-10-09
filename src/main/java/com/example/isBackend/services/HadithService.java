package com.example.isBackend.services;

import com.example.isBackend.models.Hadith;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HadithService {

    private final RestTemplate restTemplate;

    @Value("${external.api.hadith.url}")
    private String hadithApiUrl;

    public List<Hadith> getHadiths() {
        Hadith[] hadiths = restTemplate.getForObject(hadithApiUrl + "/hadiths/", Hadith[].class);
        return List.of(hadiths);
    }

    public Hadith getHadithById(Long id) {
        return restTemplate.getForObject(hadithApiUrl + "/hadiths/" + id, Hadith.class);
    }
}
