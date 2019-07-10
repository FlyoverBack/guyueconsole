package com.bootdo.system.service.impl;


import com.bootdo.system.dao.UserMapper;
import com.bootdo.system.service.UserService1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService1")
public class UserService1Impl implements UserService1 {

    @Resource
    private UserMapper userMapper;

    public String getMaxId(Integer type){ return userMapper.selectMaxId(type); }
}