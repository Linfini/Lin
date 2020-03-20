package com.seasun.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seasun.message.constant.MessageChannel;
import com.seasun.message.model.Message;
import com.seasun.message.model.MessageNotify;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;

import java.util.*;
import java.util.function.Supplier;

/**
 * 消息service 创建消息/推送消息/拉取消息等
 */
public interface MessageService extends IService<Message> {


    /**
     * 创建并推送主题消息消息,通过主题获取收件人,收件人为空时方法直接终止.
     *
     * @param messageSubject 消息主题
     * @param content        消息内容
     * @param sender         发送者
     */
    void createPushMessage(MessageSubject messageSubject, String content, Long sender);


    void createPushMessage(Subscriber subscriber, String content, Long sender, MessageChannel... channel);

    /**
     * 创建私信 channel为站内信
     *
     * @param content  content
     * @param sender   sender
     * @param receiver receiver
     */
    void createDirectMessage(String content, Long sender, Long receiver);

    /**
     * 读取消息
     *
     * @param userId    操作用户
     * @param messageId messageId
     */
    void readMessage(Long userId, Long messageId);

    /**
     * 拉取消息,根据用户订阅信息获取消息
     */
    List<Message> pullMessage();

    /**
     * 获取历史消息
     *
     * @param receiver  接收者 notnull
     * @param subject   主题 nullable
     * @param beginDate 开始事件 nullable
     * @param endDate   结束时间 nullable
     * @return res
     */
    List<MessageNotify> getHistoryMessage(Set<Long> receiver, MessageSubject subject, Date beginDate, Date endDate);


    void pushMessage(Long userId, Long messageId);

    void pushMessage(Map<Long, Long> userIdMessageIdMap);

    void pushMessage(Map<Long, Long> userIdMessageIdMap, boolean checkSubscribe);
}
