package com.xderhuo.service.impl;


import com.xderhuo.dao.UserMapper;
import com.xderhuo.domain.User;
import com.xderhuo.service.UserService;
import com.xderhuo.utils.JdbcUtils;
import tk.mybatis.mapper.entity.Example;

public class UserServiceImpl implements UserService {

	@Override
	public void register(User u) {
		//1 获得mapper
		UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);
		//2 添加
		userMapper.insert(u);
		
		//3 提交
		JdbcUtils.commitAndClose();
	}

	@Override
	public User findByUsername(String username) {
		//1 获得mapper
		UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);
		
		//2 拼凑条件
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", username);
		
		
		//3 查询
		return userMapper.selectOneByExample(example);
	}

	@Override
	public User login(String username, String password) {
		//1 获得mapper
		UserMapper userMapper = JdbcUtils.getMapper(UserMapper.class);
		
		//2 拼凑条件
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", username);
		criteria.andEqualTo("password", password);
		
		
		//3 查询
		return userMapper.selectOneByExample(example);
	}

}
