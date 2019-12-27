package com.messsage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.messsage.model.domain.Subscription;

public interface SubscriptionMapper extends BaseMapper<Subscription> {
    int deleteByPrimaryKey(Long id);

    int insert(Subscription record);

    int insertSelective(Subscription record);

    Subscription selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subscription record);

    int updateByPrimaryKey(Subscription record);
}