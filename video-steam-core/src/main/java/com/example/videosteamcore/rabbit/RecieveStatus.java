package com.example.videosteamcore.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RecieveStatus {
    private static final Logger log = LoggerFactory.getLogger(RecieveStatus.class);

    @RabbitListener(queues = "queue2")
    public void receiveMessage(final CustomMessage customMessage){
        log.info("Received message and deserialized to 'CustomMessage': {}", customMessage.toString());
    }
}
