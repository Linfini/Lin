package com.zaki.service.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

public class MessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public MessageReceiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message, String channel) {
        LOGGER.info("received <" + message + "> " + channel);
        latch.countDown();
    }
}
