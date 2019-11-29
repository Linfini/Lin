package com.zaki.service.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailSendListener implements ApplicationListener<EmailSendEvent> {
    @Override
    public void onApplicationEvent(EmailSendEvent event) {
        log.info(event.toString());
    }
}
