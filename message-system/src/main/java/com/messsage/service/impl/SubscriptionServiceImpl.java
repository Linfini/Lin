package com.messsage.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.messsage.model.domain.Subscription;
import com.messsage.service.SubscriptionService;

import java.util.List;

public class SubscriptionServiceImpl extends ServiceImpl<BaseMapper<Subscription>, Subscription> implements SubscriptionService {
    @Override
    public void subscribe(Long userId, String target, String targetType) {

    }

    @Override
    public void cancelSubscription(Long userId, String target, String targetType) {

    }

    @Override
    public List<Subscription> getSubscription(Long userId) {
        return null;
    }
}
