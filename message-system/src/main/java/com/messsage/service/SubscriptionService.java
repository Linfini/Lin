package com.messsage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.messsage.model.domain.Subscription;

import java.util.List;

public interface SubscriptionService extends IService<Subscription> {

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

    List<Subscription> getSubscription(Long userId);
}
