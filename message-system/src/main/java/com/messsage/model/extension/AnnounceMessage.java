package com.messsage.model.extension;

import com.messsage.model.domain.Message;
import com.messsage.model.enums.MessageType;

import javax.validation.Valid;
import javax.validation.constraints.Max;

/**
 * 公告消息
 */
@Valid
public class AnnounceMessage extends Message {

    public AnnounceMessage(String content, Long sender) {
        super(content, sender);
    }

    @Override
    public MessageType getType() {
        return MessageType.announcement;
    }

    @Override
    @Max(value = 400, message = "公告内容长度不能超过400")
    public String getContent() {
        return super.getContent();
    }
}
