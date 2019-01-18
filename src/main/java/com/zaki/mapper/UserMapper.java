package com.zaki.mapper;

import com.zaki.model.User;

public interface UserMapper {
    int insertSelective(User record);
}
