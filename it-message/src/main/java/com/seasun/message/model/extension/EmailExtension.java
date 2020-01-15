package com.seasun.message.model.extension;

import com.seasun.message.model.MessageTemplate;

import java.util.List;

//todo zhaijie1这个类移除了 没有存在的必要
public class EmailExtension extends MessageTemplate {
    private String subject;
    private List<Subscriber> to;
    private List<Subscriber> cc;
    private List<String> attachmentUrls;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
