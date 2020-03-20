package com.seasun.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seasun.message.constant.MessageChannel;
import com.seasun.message.model.MessageTemplate;
import com.seasun.message.model.extension.EmailContent;
import com.seasun.message.model.extension.EmailExtension;
import com.seasun.message.model.extension.MessageSubject;

import java.util.Map;

public interface MessageTemplateService extends IService<MessageTemplate> {

    /**
     * message_template中获取邮件信息(邮件主题,接收人,抄送人等)
     */
    EmailExtension getEmailExtension(MessageSubject subject);

    EmailContent getEmailContent(MessageSubject subject, Map<String, String> params);

    /**
     * 获取原始模板
     *
     * @param subject  notnull主题
     * @param language nullable
     * @param channel  nullable
     * @return 模板
     */
    MessageTemplate getOne(MessageSubject subject, String language, MessageChannel channel);

    MessageTemplate getOne(MessageSubject subject, String language, MessageChannel channel, Map<String, String> params);
}
