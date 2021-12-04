package com.example.videosteamcore.controller;

import com.example.videosteamcore.entities.FileStatus;
import com.example.videosteamcore.rabbit.RecieveStatus;
import com.example.videosteamcore.repo.MessageService;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class SenderController {
    private static final Logger log = LoggerFactory.getLogger(SenderController.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue1;

    @Autowired
    RecieveStatus recieveStatus;

    @Autowired
    MessageService messageService;

    @GetMapping("convert-file/{filename}")
    public void send(@PathVariable String filename){
        log.info("Sending message to convert file: " + filename);
        log.info("In queue: " + queue1.getName());
        messageService.save(new FileStatus(filename, 0));
        template.convertAndSend(queue1.getName(),filename);
    }

    @GetMapping("convert-status/{filename}")
    public FileStatus status(@PathVariable String filename){
        log.info("getting conversion status...");
        FileStatus fs = messageService.getFileStatus(filename);
        log.info(fs.getFileName() + " " + fs.getProgress() + "%");
        return fs;
    }



}
