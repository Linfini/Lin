package com.seasun.message.service;


import com.seasun.message.constant.MessageChannel;
import com.seasun.message.model.Message;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 消息推送类
 */
public abstract class MessagePusher {
    private static final Logger logger = LoggerFactory.getLogger(MessagePusher.class);

    private List<Subscriber> subscribers;
    private Message message;
    private MessageSubject subject;

    public MessagePusher create(Message message, List<Subscriber> subscribers) {
        Assert.notNull(message, "推送消息不能为空");
        Assert.notEmpty(subscribers, "订阅者不能为空");
        this.message = message;
        this.subscribers = subscribers;
        return this;
    }

    public MessagePusher create(Message message, List<Subscriber> subscribers, MessageSubject subject) {
        Assert.notNull(message, "推送消息不能为空");
        Assert.notEmpty(subscribers, "订阅者不能为空");
        this.message = message;
        this.subscribers = subscribers;
        this.subject = subject;
        return this;
    }

    public MessagePusher() {

    }

    protected abstract void push();

    protected abstract MessageChannel getCurrentChannel();


    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public Message getMessage() {
        return message;
    }

    public MessageSubject getSubject() {
        return subject;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void setMessage(Message message) {
        this.message = message;
    }


    public void setSubject(MessageSubject subject) {
        this.subject = subject;
    }
}
