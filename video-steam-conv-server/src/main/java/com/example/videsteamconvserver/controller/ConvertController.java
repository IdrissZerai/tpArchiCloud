package com.example.videsteamconvserver.controller;

import com.example.videsteamconvserver.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @GetMapping("{filename}")
    public String convFile(@PathVariable String filename){
        return convertService.convFile(filename);
    }

}
