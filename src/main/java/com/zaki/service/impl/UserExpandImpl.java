package com.zaki.service.impl;

import com.zaki.mapper.UserExpandMapper;
import com.zaki.model.UserExpand;
import com.zaki.service.UserExpandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zaki
 */
@Service
public class UserExpandImpl implements UserExpandService {

    @Autowired
    private UserExpandMapper userExpandMapper;
    @Override
    public int createUserExpand(UserExpand user) {
        userExpandMapper.insertSelective(user);
        return 0;
    }
}
