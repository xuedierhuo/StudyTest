package com.oahzuw.dao;

import com.oahzuw.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User>{

    @Select("select * from user where loginname=#{loginname} and password=#{password}")
    public User loginUser(@Param("loginname") String loginname, @Param("password") String password);

    @Select("select * from user where loginname=#{loginname}")
    public User login(@Param("loginname") String loginname);

    /**
     * 查询用户名是否存在
     * @param loginname
     */
    @Select("select * from user where loginname=#{loginname}")
    public User checkUsername(@Param("loginname") String loginname);
}
