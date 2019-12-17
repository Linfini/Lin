package com.messsage.service;

import com.messsage.model.Message;
import com.messsage.model.SubScription;

import java.util.List;

/**
 * 创建消息 推送消息 拉取消息
 */
public interface MessageService {

    /**
     * 新建一条公告信息
     *
     * @param content content
     * @param sender  发送者
     */
    void createAnnounce(String content, Long sender);

    /**
     * 创建消息
     *
     * @param content  content
     * @param receiver receiver
     * @param sender   sender
     */
    void createMessage(String content, Long sender, Long receiver);

    /**
     * 创建消息
     *
     * @param message message
     */
    void createMessage(Message message);


    /**
     * 用户读取消息
     *
     * @param userId    userId
     * @param messageId 消息
     */
    void readMessage(Long userId, Long messageId);

    /**
     * 忽略消息
     *
     * @param messageId 消息id
     * @param userId    operate user
     */
    void ignoreMessage(Long userId, Long messageId);


    /**
     * 拉取公告
     *
     * @return 按照公告创建时间倒叙返回消息列表
     */
    List<Message> pullAnnounce();


    /**
     * 拉取消息,根据用户订阅信息获取消息
     */
    List<Message> pullMessage();

}
