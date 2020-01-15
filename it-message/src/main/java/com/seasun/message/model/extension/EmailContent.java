package com.seasun.message.model.extension;

import com.seasun.message.model.MessageTemplate;
import com.seasun.message.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 邮件内容类
 */
public class EmailContent extends EmailExtension {

    private String content;
    private Map<String, String> params;

    @Override
    public String getContent(Map<String, String> params) {
        for (String arg : getArgs()) {
            content = content.replaceAll("#{" + arg + "}", params.getOrDefault(arg, ""));
            setSubject(getSubject().replaceAll("#{" + arg + "}", params.getOrDefault(arg, "")));
        }
        return this.getContent();
    }

    private List<String> getArgs() {
        List<String> res = new ArrayList<>();
        List<String> contentArgs = StringUtils.getRegexSubString(REGEX, content);
        List<String> subjectArgs = StringUtils.getRegexSubString(REGEX, getSubject());
        res.addAll(subjectArgs);
        res.addAll(contentArgs);
        return res;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
