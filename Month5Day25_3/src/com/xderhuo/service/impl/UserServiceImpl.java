package com.xderhuo.service.impl;

import com.xderhuo.domain.User;
import com.xderhuo.mapper.UserMapper;
import com.xderhuo.service.UserService;
import com.xderhuo.utils.MyBatisUtils;

public class UserServiceImpl implements UserService {
    @Override
    public User findUser(User user) {
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        User u = userMapper.selectByPwdAndName(user.getUsername(),user.getPassword());
        MyBatisUtils.close();
        return u;
    }
}
