package com.seasun.message.model.extension;

import com.seasun.message.constant.SubscriberType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class BaseSubscriber {
    private final Long originId;
    private final SubscriberType subscriberType;

    public BaseSubscriber(Long originId, SubscriberType subscriberType) {
        this.originId = originId;
        this.subscriberType = subscriberType;
    }

    public static BaseSubscriber create(String subscriberType, Long subscriber) {
        return new BaseSubscriber(subscriber,SubscriberType.valueOf(subscriberType));
    }

    public Long getOriginId() {
        return originId;
    }

    public SubscriberType getSubscriberType() {
        return subscriberType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BaseSubscriber that = (BaseSubscriber) o;

        return new EqualsBuilder()
                .append(originId, that.originId)
                .append(subscriberType, that.subscriberType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(originId)
                .append(subscriberType)
                .toHashCode();
    }
}
