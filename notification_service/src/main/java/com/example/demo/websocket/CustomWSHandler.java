package com.example.demo.websocket;

import com.example.demo.inMemRepository.WSRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class CustomWSHandler extends TextWebSocketHandler {
//    @Autowired
    private final WSRepository wsRepostory;

    public CustomWSHandler(WSRepository wsRepostory) {
        this.wsRepostory = wsRepostory;
    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("Recieved message : " + message.getPayload());
        session.sendMessage(new TextMessage("Echo: " + message.getPayload()));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection established with session : " + session.getId());

        String userId = (String)session.getAttributes().get("userId");
        System.out.println("User id: " + userId);

        wsRepostory.addSession(userId, session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        System.out.println("Connection closed with session: " + session.getId() + ", status: " + status);
    }
}
