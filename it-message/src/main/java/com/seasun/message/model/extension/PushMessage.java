package com.seasun.message.model.extension;

import com.seasun.message.constant.MessageType;
import com.seasun.message.model.Message;

import java.util.Date;

/**
 * 系统产生的推送消息
 */
public class PushMessage extends Message {

    protected PushMessage() {
    }

    public PushMessage(MessageSubject subject,Long sender, String content) {
        super(subject,sender, content);
    }

    @Override
    public String getType() {
        return MessageType.message.name();
    }
}
