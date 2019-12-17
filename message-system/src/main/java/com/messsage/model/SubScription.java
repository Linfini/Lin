package com.messsage.model;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.messsage.model.enums.MessageChannel;
import com.messsage.model.enums.SubscriberType;
import lombok.Data;

@Data
public class SubScription {
    private Long id;
    private Long target;
    private String targetType;
    private String action;
    @EnumValue
    private MessageChannel channel;
    private Long subscriber;
    @EnumValue
    private SubscriberType subscriberType;
    private String subscriberName;
}
