package com.messsage.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.messsage.model.domain.Message;
import com.messsage.model.extension.AnnounceMessage;
import com.messsage.model.extension.DirectMessage;
import com.messsage.service.MessageService;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 消息service
 */
public class MessageServiceImpl extends ServiceImpl<BaseMapper<Message>, Message> implements MessageService {
    /**
     * 创建公告,默认推送给所有使用cp系统的用户
     *
     * @param content content
     * @param sender  sendId
     */
    @Override
    public void createAnnounce(String content, Long sender) {
        Assert.notNull(content, "公告内容不允许为空");
        Assert.notNull(sender, "公告发送者不允许为空");
        Message message = new AnnounceMessage(content, sender);
        save(message);
    }

    @Override
    public void createDirectMessage(String content, Long sender, Long receiver) {
        Assert.notNull(content, "私信内容不允许为空");
        Assert.notNull(sender, "发送者不允许为空");
        Assert.notNull(sender, "接收者不允许为空");
        Message message = new DirectMessage(content, sender);
        save(message);
    }

    @Override
    public void createMessage(Message message) {

    }

    @Override
    public void readMessage(Long userId, Long messageId) {

    }

    @Override
    public void ignoreMessage(Long userId, Long messageId) {

    }

    @Override
    public List<Message> pullAnnounce() {
        return null;
    }

    @Override
    public List<Message> pullMessage() {
        return null;
    }
}
