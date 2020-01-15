package com.seasun.message.model.extension;

import com.seasun.message.constant.MessageChannel;
import com.seasun.message.constant.SubscriberType;
import com.seasun.message.model.Subscription;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 拥有一个订阅主题的订阅者
 */
public class SubjectSubscriber extends Subscriber {

    private final MessageSubject subject;
    private List<Subscription> subscriptionList;
    private Set<MessageSubject> messageSubjects;


    public SubjectSubscriber(Subscriber subscriber, MessageSubject subject) {
        super(subscriber.getSubscriberType(), subscriber.getOriginId(), subscriber.getUserId());
        setEmail(subscriber.getEmail());
        setPhone(subscriber.getPhone());
        setRtx(subscriber.getRtx());
        setUserName(subscriber.getUserName());
        this.subject = subject;
    }


    @Override
    public boolean hasSubject() {
        return true;
    }

    @Override
    public String getChannelString() {
        Subscription subscription = subscriptionList.parallelStream().filter(e -> subject.equals(e.getSubject())).findFirst().orElseThrow(() -> new IllegalArgumentException("没有找到订阅信息"));
        return subscription.getChannel();
    }

    @Override
    public MessageSubject getSubject() {
        return subject;
    }

    @Override
    public MessageChannel[] getMessageChannels() {
        String channelString = getChannelString();
        return MessageChannel.toArray(channelString);
    }


    @Override
    public boolean subscribeAllTarget(String action) {
        Assert.notNull(action, "主题动作不能为空");
        return subscriptionList.parallelStream().filter(e -> action.equals(e.getAction())).anyMatch(e -> e.getTarget() == null);
    }

    @Override
    public boolean subscribeAllAction() {
        return subscriptionList.parallelStream().anyMatch(e -> e.getAction() == null);
    }

    @Override
    public Set<Long> getTargets(String action) {
        return subscriptionList.parallelStream().map(Subscription::getTarget).collect(Collectors.toSet());
    }

    @Override
    public List<Subscription> getSubscriptions() {
        return subscriptionList;
    }

    @Override
    public Set<MessageSubject> getMessageSubjects() {
        return messageSubjects;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    @Override
    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public void setMessageSubjects(Set<MessageSubject> messageSubjects) {
        this.messageSubjects = messageSubjects;
    }
}
