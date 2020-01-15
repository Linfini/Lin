package com.seasun.message.model;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableName;
import com.seasun.message.constant.MessageChannel;
import com.seasun.message.constant.MessageState;
import com.seasun.message.constant.MessageType;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;
import org.springframework.util.Assert;

import java.util.Date;

@TableName(value = "m_message_notify")
public class MessageNotify extends Message {
    private Long id;

    private Long user;

    private String state;

    private Long messageId;

    private String channel;

    private Date createTime;

    private Subscriber subscriber;


    public static MessageNotify createNotify(Subscriber subscriber, Message message) {
        return createNotify(subscriber, message, null);
    }

    public static MessageNotify createNotify(Subscriber subscriber, Message message, MessageChannel... channels) {
        Assert.notNull(subscriber, "订阅者不能为空");
        Assert.notNull(message, "消息对象不能为空");
        Assert.notNull(message.getId(), "消息id不能为空");

        MessageNotify messageNotify = new MessageNotify();
        messageNotify.user = subscriber.getUserId();
        messageNotify.state = MessageState.unread.name();
        messageNotify.messageId = message.getId();
        if (subscriber.hasSubject() && channels != null) {
            messageNotify.channel = subscriber.getChannelString();
        } else {
            messageNotify.channel = JSONArray.toJSONString(channels);
        }
        messageNotify.createTime = new Date();
        return messageNotify;
    }

    public void updatePushTime() {
        createTime = new Date();
    }

    public Message getMessage() {
        return Message.newMessage(getSubject(), MessageType.valueOf(getType()), getSender(), getContent());
    }


    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}