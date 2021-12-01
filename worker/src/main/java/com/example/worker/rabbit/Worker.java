package com.example.worker.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Worker {
    private static final Logger log = LoggerFactory.getLogger(Worker.class);

    @Autowired
    SendStatus sendStatus;

    @RabbitListener(queues = "queue1")
    public void receive(String file) throws InterruptedException{
        log.info("Received order to convert file: " + file);
        sendStatus.convert(file);
    }
}
