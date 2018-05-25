package com.xderhuo.dao;

import com.xderhuo.domain.TblUser;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author XDerhuo
 */
public interface TblUserMapper extends Mapper<TblUser> {

    @Select("select * from tbl_user where user_name like #{name}")
    @Results({
            @Result(property = "userId" , column = "user_id"),
            @Result(property = "userName" , column = "user_name"),
            @Result(property = "userGender" , column = "user_gender"),
            @Result(property = "userRegisterTime" , column = "user_registerTime"),
            @Result(property = "userLastLoginTime" , column = "user_lastLoginTime"),
            @Result(property = "deptno" , column = "deptno"),
            @Result(property = "password" , column = "password"),
            @Result(property = "dept" ,  one = @One(select = "com.xderhuo.dao.DeptMapper.finDeptWithId"), column = "deptno")
    })
    List<TblUser> findAll(@Param("name")String s);
}
