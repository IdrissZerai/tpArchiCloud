package com.example.videosteamapi.controller;

import com.example.videosteamapi.entities.FileStatus;
import com.example.videosteamapi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("{filename}")
    public FileStatus getFileStatus(@PathVariable String filename){
        return statusService.getFileStatus(filename);
    }
}
