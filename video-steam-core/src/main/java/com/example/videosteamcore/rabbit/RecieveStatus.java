package com.example.videosteamcore.rabbit;

import com.example.videosteamcore.entities.FileStatus;
import com.example.videosteamcore.repo.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecieveStatus {
    private static final Logger log = LoggerFactory.getLogger(RecieveStatus.class);

    @Autowired
    MessageService messageService;

    @RabbitListener(queues = "queue2")
    public void receiveMessage(final CustomMessage customMessage){
        log.info("Received message and deserialized to 'CustomMessage': {}", customMessage.toString());
        FileStatus fl = new FileStatus(customMessage.file(),customMessage.progress());
        messageService.updateFileStatus(customMessage.file(),customMessage.progress());
        log.info("Registered to db: " + fl);
    }
}
