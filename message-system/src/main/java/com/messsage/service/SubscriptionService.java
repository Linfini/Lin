package com.messsage.service;

import com.messsage.model.SubScription;

import java.util.List;

public interface SubscriptionService {

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

    List<SubScription> getSubscription(Long userId);
}
