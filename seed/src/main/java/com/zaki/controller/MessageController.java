package com.zaki.controller;

import com.alibaba.fastjson.JSONObject;
import com.zaki.model.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/apis/auth/message")
@Slf4j
public class MessageController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CountDownLatch latch;

    @PostMapping("/publish-message")
    public ResponseEntity publishMessage(@RequestBody JSONObject body) throws InterruptedException {
        String message = body.getString("message");
        Assert.hasText(message, "message must not be empty");
        redisTemplate.convertAndSend(Constant.DEFAULT_MESSAGE_CHANNEL, message);
        return ResponseEntity.ok("success");
    }
}
