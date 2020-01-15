package com.seasun.message.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seasun.message.model.MessageTemplate;

public interface MessageTemplateMapper extends BaseMapper<MessageTemplate> {
    int deleteByPrimaryKey(Long id);

    int insert(MessageTemplate record);

    int insertSelective(MessageTemplate record);

    MessageTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageTemplate record);

    int updateByPrimaryKeyWithBLOBs(MessageTemplate record);

    int updateByPrimaryKey(MessageTemplate record);
}