package com.seasun.message.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seasun.message.model.MessageNotify;
import org.springframework.stereotype.Service;

@Service
public class MessageNotifyServiceImpl extends ServiceImpl<BaseMapper<MessageNotify>, MessageNotify> implements MessageNotifyService {
}
