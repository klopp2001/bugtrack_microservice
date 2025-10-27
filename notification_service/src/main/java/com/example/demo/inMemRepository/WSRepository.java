package com.example.demo.inMemRepository;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;

@Component
public class WSRepository {
    private final HashMap<String, WebSocketSession> userIdToWSSession = new HashMap<>();

    public void addSession(String userId, WebSocketSession session) {
        userIdToWSSession.put(userId, session);
    }

    public WebSocketSession getSession(String userId) {
        return userIdToWSSession.get(userId);
    }

}
