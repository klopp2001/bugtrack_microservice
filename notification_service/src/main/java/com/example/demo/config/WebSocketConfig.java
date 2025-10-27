package com.example.demo.config;

import com.example.demo.inMemRepository.WSRepository;
import com.example.demo.service.WSService;
import com.example.demo.websocket.CustomWSHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    WSRepository service;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new CustomWSHandler(service), "/ws").addInterceptors(new QueryParamHandshakeInterceptor()).setAllowedOrigins("*");
    }
}
