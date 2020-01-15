package com.seasun.message.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seasun.message.model.Subscription;
import com.seasun.message.model.extension.MessageSubject;
import com.seasun.message.model.extension.Subscriber;

import javax.security.auth.Subject;
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


    /**
     * 获取用户的订阅信息
     *
     * @return 订阅信息
     */
    List<Subscription> getSubscription(Long userId);

    /**
     * 获取主题subject的订阅者
     *
     * @return Subscribers
     */
    List<Subscriber> getSubscriber(MessageSubject subject);

    /**
     * 获取主题订阅者
     *
     * @param userId userId
     * @return subjectSubscriber
     */
    Subscriber getSubscriber(Long userId);

    /**
     * 获取主题订阅者
     *
     * @param userIds userId
     * @return subjectSubscriber
     */
    List<Subscriber> getSubscriber(List<Long> userIds);

}
