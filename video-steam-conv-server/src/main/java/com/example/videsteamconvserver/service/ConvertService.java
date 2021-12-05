package com.example.videsteamconvserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConvertService {
    @Value("${tparchi.core.url}")
    private String urlCore;

    private final RestTemplate restTemplate;

    public ConvertService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String convFile(String filename) {
        String urlConv = urlCore + "/convert-file/" + filename;
        return this.restTemplate.getForObject(urlConv,String.class);
    }
}
