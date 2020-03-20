package com.seasun.message.constant;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public enum MessageChannel {
    //站内信,邮件,微信,短信
    inside,
    email,
    weChat,
    sms,
    rtx,
    app;

    public static MessageChannel[] toArray(String messageChannels) {
        List<MessageChannel> list = JSONArray.parseArray(messageChannels, MessageChannel.class);
        return list.toArray(MessageChannel.values());
    }


    public static List<MessageChannel> toList(String messageChannels) {
        return JSONArray.parseArray(messageChannels, MessageChannel.class);
    }

    public static MessageChannel[] remove(MessageChannel[] channels, MessageChannel channel) {
        List<MessageChannel> res = new ArrayList<>();
        for (MessageChannel messageChannel : channels) {
            if (messageChannel.equals(channel)) {
                continue;
            }
            res.add(messageChannel);
        }
        return res.toArray(new MessageChannel[0]);
    }
}
