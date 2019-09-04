package com.zaki.controller;

import com.google.gson.JsonObject;
import com.zaki.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apis/auth")
public class WebSocketController {


    @Autowired
    private WebSocketService webSocketService;

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage(@RequestBody Map<String, Object> body) {
        String uid = (String) body.get("uid");
        String message = (String) body.get("message");
        webSocketService.sendMessage(new TextMessage(message));
        return ResponseEntity.ok().build();
    }
}
