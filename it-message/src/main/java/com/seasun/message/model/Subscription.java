package com.seasun.message.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.seasun.message.constant.SubscriberType;
import com.seasun.message.model.extension.BaseSubscriber;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;

import java.util.List;

@TableName("m_subscription")
public class Subscription implements Cloneable {
    private Long id;

    private Long target;

    private String targetType;

    private String action;

    private String channel;

    private Long subscriber;

    private String subscriberType;

    @TableField(exist = false)
    private Subscriber subscriberInstance;

    @Override
    public Subscription clone() {
        Subscription res = null;
        try {
            res = (Subscription) super.clone();
            if (subscriberInstance != null) {
                res.subscriberInstance = subscriberInstance.clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return res;
    }

    public BaseSubscriber getBaseSubscriber() {
        return BaseSubscriber.create(subscriberType, subscriber);
    }

    public MessageSubject getSubject() {
        return MessageSubject.create(targetType, action, target);
    }


    public Subscriber getSubscriberInstance() {
        return subscriberInstance;
    }

    public void setSubscriberInstance(Subscriber subscriberInstance) {
        this.subscriberInstance = subscriberInstance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.targetType = targetType == null ? null : targetType.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Long getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Long subscriber) {
        this.subscriber = subscriber;
    }

    public String getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType == null ? null : subscriberType.trim();
    }
}