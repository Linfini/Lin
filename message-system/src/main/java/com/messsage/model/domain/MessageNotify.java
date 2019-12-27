package com.messsage.model.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.messsage.model.enums.MessageChannel;
import com.messsage.model.enums.MessageState;
import lombok.Data;

import java.util.Date;

@Data
public class MessageNotify {
    private Long id;
    private Long user;
    @EnumValue
    private MessageState state;
    private Long messageId;
    @EnumValue
    private MessageChannel channel;
    private Date createTime;
    private Message message;
}
