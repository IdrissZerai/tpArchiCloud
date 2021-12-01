package com.example.videosteamcore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SenderController {
    private static final Logger log = LoggerFactory.getLogger(SenderController.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue1;

    @GetMapping("convert-file/{filename}")
    public void send(@PathVariable String filename){
        log.info("Sending message to convert file: " + filename);
        log.info("In queue: " + queue1.getName());
        template.convertAndSend(queue1.getName(),filename);
    }

}
