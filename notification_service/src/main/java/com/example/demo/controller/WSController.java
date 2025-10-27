package com.example.demo.controller;

import com.example.demo.dto.WSMessageDTO;
import com.example.demo.service.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WSController {
    @Autowired
    WSService wsService;

    @PostMapping("/send")
    public void sendMessageToClient(@RequestBody WSMessageDTO dto) {
        try {
            wsService.sendMessage(dto.getUserId(), dto.getMessage());
        } catch (IOException e) {
            System.out.println("Error while sending message back to " + dto.getUserId() + " with message: " + dto.getMessage() );
        }
    }
}
