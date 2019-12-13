package com.messsage.model;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Long id;
    private String content;
    @EnumValue
    private MessageType type;
    private Long target;
    private String targetType;
    private String action;
    private Long sender;
    private Date createTime;
}
