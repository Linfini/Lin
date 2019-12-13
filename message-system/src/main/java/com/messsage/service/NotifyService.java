package com.messsage.service;

import com.messsage.model.MessageState;

/**
 * 创建消息 推送消息 拉取消息
 */
public interface NotifyService {
    /**
     * 创建消息
     */
    void createMessage(String content, Long sender);

    /**
     * 用户读取消息
     *
     * @param userId    userId
     * @param messageId 消息
     * @param state     state
     */
    void readMessage(Long userId, Long messageId, MessageState state);

    /**
     * 订阅
     *
     * @param target     订阅目标
     * @param targetType 订阅动作类型
     * @param userId     userId 用户id
     */
    void subscribe(Long userId, String target, String targetType);

    /**
     * 取消订阅
     *
     * @param target     订阅目标
     * @param targetType 订阅动作类型
     * @param userId     userId 用户id
     */
    void cancelSubscription(Long userId, String target, String targetType);



}
