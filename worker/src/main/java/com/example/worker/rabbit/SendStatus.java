package com.example.worker.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendStatus {
    private static final Logger log = LoggerFactory.getLogger(SendStatus.class);

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue2;



    public void convert(String file) throws InterruptedException {
        // conversion will take 0.1sec per 1% i.e 10sec in total
        for(int i=1;i<=10;i++){
            reportStatus(file,i);
            Thread.sleep(1000);
        }
    }

    public void reportStatus(String file, int i){
        CustomMessage customMessage = new CustomMessage(file,i);
        log.info("Reporting conversion status: " + customMessage);
        template.convertAndSend(queue2.getName(),customMessage);
    }
}
