package com.messsage.model.extension;

import com.messsage.model.domain.Message;
import com.messsage.model.enums.MessageType;

/**
 * 私信消息
 * */
public class DirectMessage extends Message {

    public DirectMessage(String content, Long sender) {
        super(content, sender);
    }

    @Override
    public MessageType getType() {
        return MessageType.direct;
    }
}
