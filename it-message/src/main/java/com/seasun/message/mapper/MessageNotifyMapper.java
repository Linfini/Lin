package com.seasun.message.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seasun.message.model.MessageNotify;
import com.seasun.message.model.extension.MessageSubject;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface MessageNotifyMapper extends BaseMapper<MessageNotify> {
    int deleteByPrimaryKey(Long id);

    int insert(MessageNotify record);

    int insertSelective(MessageNotify record);

    MessageNotify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageNotify record);

    int updateByPrimaryKey(MessageNotify record);

    List<MessageNotify> selectByReceiverAndSubjectAndDate(@Param("receivers") Set<Long> receiver, @Param("subject") MessageSubject subject, @Param("begin") Date beginDate, @Param("end") Date endDate);
}