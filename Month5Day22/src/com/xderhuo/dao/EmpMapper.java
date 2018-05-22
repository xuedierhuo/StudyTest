package com.xderhuo.dao;

import com.xderhuo.domain.Emp;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmpMapper extends Mapper<Emp> {
    @Select("select * from emp")
    @Results({
            @Result(property = "empno", column = "empno"),
            @Result(property = "ename", column = "ename"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "email", column = "email"),
            @Result(property = "deptno", column = "deptno"),
            @Result(property = "dept", one = @One(select = "com.xderhuo.dao.DeptMapper.findDeptWithId") ,column = "deptno"),
    })
    List<Emp> findAll();
}
