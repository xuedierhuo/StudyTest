package com.xderhuo.mapper;

import com.xderhuo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username = #{username} and password = #{password}")
    User selectByPwdAndName(@Param("username") String username, @Param("password") String password);
}