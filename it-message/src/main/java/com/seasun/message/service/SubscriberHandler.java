package com.seasun.message.service;

import com.seasun.message.constant.SubscriberType;
import com.seasun.message.model.extension.Subscriber;

import java.util.List;
import java.util.Map;

/**
 * 订阅者处理器,由客户端负责实现
 */
public interface SubscriberHandler {

    /**
     * 根据id和订阅类型获取订阅者
     *
     * @param id   id
     * @param type type
     * @return 订阅者信息
     */
    List<Subscriber> getById(Long id, SubscriberType type);

    /**
     * 根据id和订阅类型获取订阅者
     *
     * @param ids  ids
     * @param type type
     * @return 订阅者信息
     */
    List<Subscriber> getByIds(List<Long> ids, SubscriberType type);

    /**
     * 根据id和订阅类型获取订阅者
     *
     * @param paramMap params
     * @return 订阅者信息
     */
    List<Subscriber> getByMap(Map<SubscriberType, List<Long>> paramMap);

}
