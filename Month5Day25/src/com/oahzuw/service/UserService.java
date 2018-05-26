package com.oahzuw.service;

import com.oahzuw.dao.UserMapper;
import com.oahzuw.domain.User;
import com.oahzuw.utils.JdbcUtils;

/**
 * @author 周迪
 */
public class UserService {

    public User findAllUser(User user){
        UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);
        User loginUser = userMapper.loginUser(user.getLoginname(),user.getPassword());
        JdbcUtils.release();
        return loginUser;
    }

    public User login(String loginname){
        UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);

        User loginUser = userMapper.login(loginname);
        JdbcUtils.commitAndClose();
        return loginUser;
    }

    public void saveuser(User user) {
        UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);
        userMapper.insert(user);
        JdbcUtils.commitAndClose();
    }

    public User checkUsername(String loginname) {
        UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);
        User user = userMapper.checkUsername(loginname);
        JdbcUtils.commitAndClose();
        return user;
    }
}
