package com.messsage.model;

import com.baomidou.mybatisplus.annotation.EnumValue;
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
