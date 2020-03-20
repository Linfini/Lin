package com.seasun.message.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seasun.message.constant.MessageChannel;
import com.seasun.message.constant.MessageType;
import com.seasun.message.mapper.MessageNotifyMapper;
import com.seasun.message.model.Message;
import com.seasun.message.model.MessageNotify;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;
import com.seasun.message.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;
import java.util.function.Supplier;

/**
 * 消息默认实现类
 */
@Service("MessageServiceImpl")
public class MessageServiceImpl extends ServiceImpl<BaseMapper<Message>, Message> implements MessageService {


    private static Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private MessageNotifyService messageNotifyService;
    @Autowired
    private MessageNotifyMapper messageNotifyMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPushMessage(MessageSubject messageSubject, String content, Long sender) {
        Assert.notNull(messageSubject, "主题不能为空");
        Assert.notNull(messageSubject.getTargetType(), "主题target不能为空");
        Assert.notNull(content, "发送内容不能为空");
        Assert.notNull(sender, "发送者不能为空");

        Message message = Message.newMessage(messageSubject, MessageType.message, sender, content);
        save(message);

        List<Subscriber> subscribers = subscriptionService.getSubscriber(messageSubject);
        if (subscribers.isEmpty()) {
            return;
        }

        List<MessageNotify> messageNotifies = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            messageNotifies.add(MessageNotify.createNotify(subscriber, message));
        }
        messageNotifyService.saveBatch(messageNotifies);
        MessagePushContext.pushMessage(messageSubject, message, subscribers);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPushMessage(Subscriber subscriber, String content, Long sender, MessageChannel... channels) {
        Message message = Message.newMessage(subscriber.getSubject(), MessageType.message, sender, content);
        save(message);
        MessageNotify notify = MessageNotify.createNotify(subscriber, message, channels);
        messageNotifyService.save(notify);

        List<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(subscriber);
        MessagePushContext.pushMessage(message, subscribers, channels);
    }

    @Override
    public void createDirectMessage(String content, Long sender, Long receiver) {

    }


    @Override
    public void readMessage(Long userId, Long messageId) {

    }

    @Override
    public List<Message> pullMessage() {
        return null;
    }

    @Override
    public List<MessageNotify> getHistoryMessage(Set<Long> receiver, MessageSubject subject, Date beginDate, Date endDate) {
        Assert.notNull(receiver, "消息接收者id不能为空");
        return messageNotifyMapper.selectByReceiverAndSubjectAndDate(receiver, subject, beginDate, endDate);
    }

    @Override
    public void pushMessage(Long userId, Long messageId) {
        LOG.info("begin push message ");
        Map<Long, Long> userIdMessageIdMap = new HashMap<>();
        userIdMessageIdMap.put(userId, messageId);
        pushMessage(userIdMessageIdMap);
    }

    @Override
    public void pushMessage(Map<Long, Long> userIdMessageIdMap) {
        pushMessage(userIdMessageIdMap, true);
    }

    @Override
    public void pushMessage(Map<Long, Long> userIdMessageIdMap, boolean checkSubscribe) {
        LOG.info("begin push message ");
        List<MessageNotify> historyMessage = getHistoryMessage(userIdMessageIdMap);
        if (checkSubscribe) {
            //todo 检查订阅,去掉不符合订阅的的messageNotify
        }
        for (MessageNotify messageNotify : historyMessage) {
            messageNotify.updatePushTime();
            MessagePushContext.pushMessage(messageNotify.getSubscriber().getSubject(), messageNotify.getMessage(), Lists.newArrayList(messageNotify.getSubscriber()));
        }
    }


    private List<MessageNotify> getHistoryMessage(Map<Long, Long> userIdMessageIdMap) {
        if (userIdMessageIdMap.isEmpty()) {
            return Collections.emptyList();
        }
        List<MessageNotify> historyMessage = getHistoryMessage(userIdMessageIdMap.keySet(), null, null, null);
        List<Subscriber> subscribers = subscriptionService.getSubscriber(new ArrayList<>(userIdMessageIdMap.keySet()));
        Map<Long, Subscriber> subscriberMap = subscribers.parallelStream().collect(HashMap::new, (m, e) -> m.put(e.getUserId(), e), HashMap::putAll);
        for (MessageNotify messageNotify : historyMessage) {
            messageNotify.setSubscriber(subscriberMap.get(messageNotify.getUser()));
        }
        return historyMessage;
    }
}
