package com.seasun.message.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seasun.message.model.Subscription;
import com.seasun.message.model.extension.BaseSubscriber;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

public interface SubscriptionMapper extends BaseMapper<Subscription> {
    int deleteByPrimaryKey(Long id);

    int insert(Subscription record);

    int insertSelective(Subscription record);

    Subscription selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subscription record);

    int updateByPrimaryKey(Subscription record);

    List<Subscription> selectByBaseSubscriber(@Param("base") Set<BaseSubscriber> baseSubscriberList);
}