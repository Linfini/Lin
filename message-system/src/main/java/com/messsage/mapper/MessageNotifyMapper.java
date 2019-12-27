package com.messsage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.messsage.model.domain.MessageNotify;

public interface MessageNotifyMapper extends BaseMapper<MessageNotify> {
    int deleteByPrimaryKey(Long id);

    int insert(MessageNotify record);

    int insertSelective(MessageNotify record);

    MessageNotify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageNotify record);

    int updateByPrimaryKey(MessageNotify record);
}