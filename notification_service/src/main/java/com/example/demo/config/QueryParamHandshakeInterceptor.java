package com.example.demo.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class QueryParamHandshakeInterceptor implements HandshakeInterceptor {


    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String query = request.getURI().getQuery();
        if (query != null) {
            // Parse the query string and add parameters to WebSocket session attributes
            // Example: param1=value1&param2=value2
            for (String param : query.split("&")) {
                String[] parts = param.split("=");
                if (parts.length == 2) {
                    attributes.put(parts[0], parts[1]);
                }
            }
        }
        return true; // Continue the handshake
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
