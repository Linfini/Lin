package com.seasun.message.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.seasun.message.constant.MessageType;
import com.seasun.message.model.extension.DirectMessage;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.PushMessage;

import java.util.Date;

@TableName(value = "m_message")
public class Message {
    private Long id;

    private String type;

    private Long target;

    private String targetType;

    private String action;

    private Long sender;

    private Date createTime;

    private String content;

    public Message() {
    }

    protected Message(MessageSubject subject, Long sender, String content) {
        this.sender = sender;
        this.content = content;
        this.targetType = subject.getTargetType();
        this.target = subject.getTarget();
        this.action = subject.getAction();
        setCreateTime(new Date());
    }

    public static Message newMessage(MessageSubject subject, MessageType type, Long sender, String content) {
        Message message = null;
        switch (type) {
            case message:
                message = new PushMessage(subject, sender, content);
                break;
            case direct:
                message = new DirectMessage(subject, sender, content);
                break;
            default:
                return message;
        }

        return message;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType == null ? null : targetType.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public MessageSubject getSubject() {
        return MessageSubject.create(targetType, action, target);
    }
}