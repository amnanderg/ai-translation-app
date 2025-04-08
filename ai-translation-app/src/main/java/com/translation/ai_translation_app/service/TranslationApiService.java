package com.translation.ai_translation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationApiService {

    private final RestTemplate restTemplate;

    private final String API_URL = "http://127.0.0.1:5000/translate";

    @Autowired
    public TranslationApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String translateText(String text, String fromLanguage, String toLanguage) {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("q", text);
        requestBody.put("source", fromLanguage);
        requestBody.put("target", toLanguage);
        requestBody.put("format", "text");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(API_URL, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            Object translated = response.getBody().get("translatedText");

            if (translated != null) {
                return translated.toString();
            }

        }

        return "[Translation Error]";

    }
}
