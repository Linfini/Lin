package com.zaki.service.impl;

import com.zaki.config.datasource.DataSourceContextHolder;
import com.zaki.mapper.UserExpandMapper;
import com.zaki.mapper.UserMapper;
import com.zaki.model.User;
import com.zaki.model.UserExpand;
import com.zaki.service.UserExpandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zaki
 */
@Service
public class UserExpandImpl implements UserExpandService {

    @Autowired
    private UserExpandMapper userExpandMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int createUserExpand(UserExpand user) {

        userExpandMapper.insertSelective(user);
        User userIt = new User();
        userIt.setFirstName(user.getUserName());
        userIt.setLastName(user.getProfile());
        DataSourceContextHolder.useSecond();
        userMapper.insertSelective(userIt);
        return 0;
    }

    @Override
    @Transactional
    public void add(int i) {
        ++i;
    }

}
