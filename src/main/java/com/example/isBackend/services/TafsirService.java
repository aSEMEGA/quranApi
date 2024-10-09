package com.example.isBackend.services;

import com.example.isBackend.models.Tafsir;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TafsirService {

    @Value("${external.api.tafsir.url}")
    private String tafsirApiUrl;

    private RestTemplate restTemplate;

    public List<Tafsir> getTafsirs() {
        Tafsir[] tafsirs = restTemplate.getForObject(tafsirApiUrl + "/tafsirs", Tafsir[].class);
        return List.of(tafsirs);
    }

    public Tafsir getTafsirById(Long id) {
        return restTemplate.getForObject(tafsirApiUrl + "/tafsirs/" + id, Tafsir.class);
    }
}
