package com.xderhuo.service.impl;

import com.xderhuo.domain.Book;
import com.xderhuo.domain.User;
import com.xderhuo.mapper.UserMapper;
import com.xderhuo.service.UserService;
import com.xderhuo.utils.MyBatisUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        UserMapper userMapper = MyBatisUtils.getMapper(UserMapper.class);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        criteria.andEqualTo("password",user.getPassword());

        List<User> users = userMapper.selectByExample(example);
        MyBatisUtils.close();
        if (users.size() == 0){
            return null;
        }
        return users.get(0);
    }
}
