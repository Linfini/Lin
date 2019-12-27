package com.messsage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.messsage.model.domain.Message;

public interface MessageMapper extends BaseMapper<Message> {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}