package com.seasun.message.model.extension;

import com.seasun.message.constant.MessageChannel;
import com.seasun.message.constant.SubscriberType;
import com.seasun.message.model.Subscription;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Subscriber extends BaseSubscriber implements Cloneable {

    private final Long userId;
    private String rtx;
    private String userName;
    private String email;
    private String phone;

    public Subscriber(SubscriberType type, Long originId, Long userId) {
        super(originId, type);
        this.userId = userId;
    }


    public MessageChannel[] getMessageChannels() {
        return new MessageChannel[0];
    }

    public boolean hasSubject() {
        return false;
    }

    public String getChannelString() {
        throw new IllegalArgumentException("获取订阅通道信息失败");
    }

    public MessageSubject getSubject() {
        throw new IllegalArgumentException("获取信息失败");
    }

    /**
     * 是否订阅了所有目标
     */
    public boolean subscribeAllTarget(String action) {
        return false;
    }

    /**
     * 是否订阅了所有动作
     */
    public boolean subscribeAllAction() {
        return false;
    }

    public Set<String> getActions() {
        return Collections.emptySet();
    }

    public Set<Long> getTargets(String action) {
        return Collections.emptySet();
    }

    @Override
    public Subscriber clone() {
        try {
            return (Subscriber) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<MessageSubject> getMessageSubjects() {
        throw new IllegalArgumentException("获取信息失败");
    }

    /**
     * ----------------------------------------
     */


    public BaseSubscriber getBaseSubscriber() {
        return new BaseSubscriber(getOriginId(), getSubscriberType());
    }


    public String getRtx() {
        return rtx;
    }

    public void setRtx(String rtx) {
        this.rtx = rtx;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public List<Subscription> getSubscriptions() {
        return new ArrayList<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        return new EqualsBuilder()
                .append(userId, that.userId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(userId)
                .toHashCode();
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        throw new IllegalArgumentException("setter方法调用失败");
    }
}
