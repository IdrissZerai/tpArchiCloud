package com.example.videosteamcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VideoSteamCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoSteamCoreApplication.class, args);
    }

}
