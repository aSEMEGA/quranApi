package com.example.isBackend.services;

import com.example.isBackend.models.Jurisprudence;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JurisprudenceService {

    @Value("${external.api.jurisprudence.url}")
    private String jurisprudenceApiUrl;

    private RestTemplate restTemplate;

    public List<Jurisprudence> getJurisprudences() {
        Jurisprudence[] jurisprudences = restTemplate.getForObject(jurisprudenceApiUrl + "/jurisprudences", Jurisprudence[].class);
        return List.of(jurisprudences);
    }

    public Jurisprudence getJurisprudenceById(Long id) {
        return restTemplate.getForObject(jurisprudenceApiUrl + "/jurisprudences/" + id, Jurisprudence.class);
    }
}
