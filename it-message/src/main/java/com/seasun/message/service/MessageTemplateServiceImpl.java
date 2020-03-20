package com.seasun.message.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seasun.message.constant.MessageChannel;
import com.seasun.message.model.MessageTemplate;
import com.seasun.message.model.extension.EmailContent;
import com.seasun.message.model.extension.EmailExtension;
import com.seasun.message.model.extension.MessageSubject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class MessageTemplateServiceImpl extends ServiceImpl<BaseMapper<MessageTemplate>, MessageTemplate> implements MessageTemplateService {

    @Override
    public EmailExtension getEmailExtension(MessageSubject subject) {
        Assert.notNull(subject, "消息主题不能为空");
        Assert.notNull(subject.getTargetType(), "消息主题target不能为空");
        MessageTemplate template = getOne(subject, null, MessageChannel.email);
        if (template == null) {
            throw new IllegalArgumentException("获取模板失败");
        }
        return template.getEmailExtensionInstance();
    }

    @Override
    public EmailContent getEmailContent(MessageSubject subject, Map<String, String> params) {
        MessageTemplate messageTemplate = getOne(subject, null, MessageChannel.email);
        EmailContent emailContent = new EmailContent();
        BeanUtils.copyProperties(messageTemplate, emailContent);
        emailContent.getContent(params);
        return emailContent;
    }

    @Override
    @SuppressWarnings("all")
    public MessageTemplate getOne(MessageSubject subject, String language, MessageChannel channel) {
        Assert.notNull(subject, "消息主题不能为空");
        Assert.notNull(subject.getTargetType(), "消息主题target不能为空");

        if (StringUtils.isEmpty(language)) {
            language = "default";
        }

        QueryWrapper<MessageTemplate> wrapper = new QueryWrapper<>(new MessageTemplate());
        wrapper.select("*").eq("target_type", subject.getTargetType())
                .eq(subject.getAction() != null, "action", subject.getAction()).isNull(subject.getAction() == null, "action")
                .eq(subject.getTarget() != null, "target", subject.getTarget()).isNull(subject.getTarget() == null, "target")
                .eq("language", language);
        if (channel == null) {
            wrapper.isNull("channel");
        } else {
            wrapper.eq("channel", channel);
        }
        return getOne(wrapper);
    }

    @Override
    public MessageTemplate getOne(MessageSubject subject, String language, MessageChannel channel, Map<String, String> params) {
        MessageTemplate messageTemplate = getOne(subject, language, channel);
        messageTemplate.getContent(params);
        return messageTemplate;
    }
}
