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

@RestController
@RequestMapping("/apis/auth")
public class WebSocketController {


    @Autowired
    private WebSocketService webSocketService;

    @PostMapping("/message")
    public ResponseEntity<?> sendMessage(@RequestBody JsonObject body) {
        String uid = body.getAsJsonPrimitive("uid").getAsString();
        String message = body.getAsJsonPrimitive("message").getAsString();
        webSocketService.sendMessage(new TextMessage(message));
        return ResponseEntity.ok().build();
    }
}
