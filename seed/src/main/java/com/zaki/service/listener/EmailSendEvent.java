package com.zaki.service.listener;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmailSendEvent extends ApplicationEvent {

    private final String sendTo;
    private final String sendBy;
    private final String content;

    public EmailSendEvent(Object source, String sendTo, String sendBy, String content) {
        super(source);
        this.sendTo = sendTo;
        this.sendBy = sendBy;
        this.content = content;
    }
}
