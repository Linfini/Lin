package com.messsage.model.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.messsage.model.enums.MessageType;
import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Long id;
    private String content;
    @EnumValue
    private MessageType type;
    private Long target;
    private String targetType;
    private String action;
    private Long sender;
    private Date createTime;

    public Message(String content, Long sender) {
        this.content = content;
        this.sender = sender;
    }

    public Message createMessage() {
        this.createTime = new Date();
        return this;
    }
}
