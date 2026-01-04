package com.example.demo.service;

import com.example.demo.inMemRepository.WSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;

@Service
public class WSService {
    @Autowired
    WSRepository wsRepository;

    public void sendMessage(String userId, String message) throws IOException {
        wsRepository.getSession(userId).sendMessage(new TextMessage(message));
    }

}
