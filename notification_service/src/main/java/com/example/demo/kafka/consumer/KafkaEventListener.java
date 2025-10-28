package com.example.demo.kafka.consumer;

import com.example.demo.service.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springbot.com_dto.NotificationEventDto;

import javax.management.Notification;
import java.io.IOException;

@Service
public class KafkaEventListener {
    @Autowired
    private WSService wsService;

    @KafkaListener(topics = "notification.project", groupId = "notification-creator")
    public void consumeProjectNotification(NotificationEventDto dto) {
        System.out.println("EVENT WITH USER ID: " + dto.getUserId() + " MESSAGE: " + dto.getPayload());
        try {
            wsService.sendMessage(String.valueOf(dto.getUserId()), dto.getPayload());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
