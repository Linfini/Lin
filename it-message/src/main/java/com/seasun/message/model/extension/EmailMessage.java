package com.seasun.message.model.extension;

import com.seasun.message.model.Message;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 邮件消息
 */
public class EmailMessage extends PushMessage {
    private String emailSubject;
    private List<Subscriber> to;
    private List<Subscriber> cc;
    private List<String> attachmentUrls;


    public EmailMessage(Message message, EmailExtension emailInfo) {
        BeanUtils.copyProperties(message, this);
        this.emailSubject = emailInfo.getSubject();
        this.to = emailInfo.getTo();
        this.cc = emailInfo.getCc();
        this.attachmentUrls = emailInfo.getAttachmentUrls();
    }

    private EmailMessage(Message message) {
        BeanUtils.copyProperties(message, this);
    }


    public String getEmailSubject() {
        return emailSubject;
    }

    public void setSubject(String subject) {
        this.emailSubject = subject;
    }

    public List<Subscriber> getTo() {
        return to;
    }

    public void setTo(List<Subscriber> to) {
        this.to = to;
    }

    public List<Subscriber> getCc() {
        return cc;
    }

    public void setCc(List<Subscriber> cc) {
        this.cc = cc;
    }

    public List<String> getAttachmentUrls() {
        return attachmentUrls;
    }

    public void setAttachmentUrls(List<String> attachmentUrls) {
        this.attachmentUrls = attachmentUrls;
    }
}
