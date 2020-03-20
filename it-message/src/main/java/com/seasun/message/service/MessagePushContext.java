package com.seasun.message.service;


import com.seasun.message.constant.MessageChannel;
import com.seasun.message.model.Message;
import com.seasun.message.model.Subscription;
import com.seasun.message.model.extension.EmailMessage;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;
import com.seasun.message.tx.MessageContext;
import com.seasun.message.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//todo zhaijei1 优化消息推送器 削峰
public class MessagePushContext {
    private static Logger LOG = LoggerFactory.getLogger(MessagePushContext.class);
    private static List<MessagePusher> pushers = new ArrayList<>();


    public static void addPusher(MessagePusher pusher) {
        pushers.add(pusher);
    }

    static void pushMessage(MessageSubject messageSubject, Message message, List<Subscriber> subscribers) {
        Assert.notEmpty(MessagePushContext.getPushers(), "尚未初始化消息推送器");
        List<Subscriber> subjectSubscribers = subjectSubscriber(subscribers, false);
        for (MessagePusher pusher : MessagePushContext.getPushers()) {
            Assert.notNull(message, "推送消息不能为空");
            Assert.notEmpty(subscribers, "订阅者不能为空");
            pusher.create(message, getSubscriber(pusher.getCurrentChannel(), subjectSubscribers), messageSubject);
            //处理邮件消息
            if (MessageChannel.email.equals(pusher.getCurrentChannel())) {
                try {
                    EmailMessage emailMessage = new EmailMessage(message, BeanUtils.getBean(MessageTemplateService.class).getEmailExtension(messageSubject));
                    pusher.setMessage(emailMessage);
                } catch (IllegalArgumentException e) {
                    LOG.error("发送邮件失败:" + e.getMessage());
                }
            }
            pusher.push();
        }

    }

    static void pushMessage(Message message, List<Subscriber> subscribers, MessageChannel... channels) {
        Assert.notEmpty(MessagePushContext.getPushers(), "尚未初始化消息推送器");
        for (MessagePusher pusher : MessagePushContext.getPushers()) {
            pusher.create(message, subscribers);
            if (Arrays.asList(channels).contains(MessageChannel.email)) {
                LOG.error("消息:{}使用邮件发送失败,原因无法获取邮件配置", message.getContent());
                channels = MessageChannel.remove(channels, MessageChannel.email);
            }
            if (Arrays.asList(channels).contains(pusher.getCurrentChannel())) {
                pusher.push();
            }
        }
    }

    private static List<Subscriber> subjectSubscriber(List<Subscriber> subscribers, boolean throwException) {
        Iterator<Subscriber> iterator = subscribers.iterator();
        while (iterator.hasNext()) {
            boolean b = iterator.next().hasSubject();
            if (!b) {
                iterator.remove();
                if (throwException) {
                    throw new IllegalArgumentException("主题订阅者才能发送信息");
                }
            }
        }
        return subscribers;
    }

    /**
     * 获取包含 channel推送的订阅者
     */
    private static List<Subscriber> getSubscriber(MessageChannel channel, List<Subscriber> subscribers) {
        List<Subscriber> res = new ArrayList<>();

        Map<String, List<Subscriber>> subscriberMap = subscribers.parallelStream().collect(Collectors.groupingBy(Subscriber::getChannelString));
        for (Map.Entry<String, List<Subscriber>> entry : subscriberMap.entrySet()) {
            if (entry.getKey().contains(channel.name())) {
                res.addAll(entry.getValue());
            }
        }
        return res;
    }


    private static List<MessagePusher> getPushers() {
        return pushers;
    }


}
