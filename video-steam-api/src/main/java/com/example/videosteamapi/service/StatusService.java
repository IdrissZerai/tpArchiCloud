package com.example.videosteamapi.service;

import com.example.videosteamapi.entities.FileStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatusService {
    @Value("${tparchi.core.url}")
    private String urlCore;

    private final RestTemplate restTemplate;

    public StatusService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public FileStatus getFileStatus(String filename) {
        String urlGetFS = urlCore + "/convert-status/" + filename;
        return this.restTemplate.getForObject(urlGetFS, FileStatus.class);
    }
}
