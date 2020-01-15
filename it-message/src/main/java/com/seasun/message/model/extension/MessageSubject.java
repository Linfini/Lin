package com.seasun.message.model.extension;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.util.Assert;

/**
 * 消息主题
 */
public class MessageSubject {

    private Long target;

    private String targetType;

    private String action;

    public static MessageSubject create(String targetType, String action, Long target) {
        MessageSubject messageSubject = new MessageSubject();
        messageSubject.targetType = targetType;
        messageSubject.action = action;
        messageSubject.target = target;
        return messageSubject;
    }

    protected boolean existsTemplate() {
        return false;
    }


    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        MessageSubject that = (MessageSubject) o;
        return new EqualsBuilder()
                .append(getTarget(), that.getTarget())
                .append(getTargetType(), that.getTargetType())
                .append(getAction(), that.getAction())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getTarget())
                .append(getTargetType())
                .append(getAction())
                .toHashCode();
    }
}
