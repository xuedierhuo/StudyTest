package com.xderhuo.service;


import com.xderhuo.domain.User;

public interface UserService {

	/**
	 * 用户注册
	 * @param u
	 */
	void register(User u);

	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

}
