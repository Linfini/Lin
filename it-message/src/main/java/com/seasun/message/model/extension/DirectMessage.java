package com.seasun.message.model.extension;

import com.seasun.message.constant.MessageType;

public class DirectMessage extends com.seasun.message.model.Message {

    public DirectMessage(MessageSubject subject,Long sender, String content) {
        super(subject,sender, content);
    }

    @Override
    public String getType() {
        return MessageType.direct.name();
    }
}
