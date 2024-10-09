package com.example.isBackend.services;

import com.example.isBackend.models.CultureGenerale;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CultureGeneralService {

    @Value("${external.api.culture.url}")
    private String cultureApiUrl;


    private RestTemplate restTemplate;

    public List<CultureGenerale> getCultureArticles() {
        CultureGenerale[] articles = restTemplate.getForObject(cultureApiUrl + "/articles", CultureGenerale[].class);
        return List.of(articles);
    }

    public CultureGenerale getCultureArticleById(Long id) {
        return restTemplate.getForObject(cultureApiUrl + "/articles/" + id, CultureGenerale.class);
    }
}
