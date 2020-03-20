package com.seasun.message.model;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import com.seasun.message.model.extension.EmailExtension;
import com.seasun.message.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@TableName(value = "m_message_template")
public class MessageTemplate {
    protected static final String REGEX = "\\#\\{([\\w]*)\\}";

    private Long id;

    private String targetType;

    private String action;

    private String target;

    private String template;

    private String language;

    private String channel;

    private String emailExtension;


    public String getContent(Map<String, String> params) {
        for (String arg : getArgs()) {
            template = template.replaceAll("#{" + arg + "}", params.getOrDefault(arg, ""));
            emailExtension = emailExtension.replaceAll("#{" + arg + "}", params.getOrDefault(arg, ""));
        }
        return getTemplate();
    }

    private List<String> getArgs() {
        List<String> res = new ArrayList<>();
        List<String> contentArgs = StringUtils.getRegexSubString(REGEX, template);
        List<String> subjectArgs = StringUtils.getRegexSubString(REGEX, emailExtension);
        res.addAll(subjectArgs);
        res.addAll(contentArgs);
        return res;
    }


    public EmailExtension getEmailExtensionInstance() {
        return JSONObject.parseObject(emailExtension, EmailExtension.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getEmailExtension() {
        return emailExtension;
    }

    public void setEmailExtension(String emailExtension) {
        this.emailExtension = emailExtension;
    }


}