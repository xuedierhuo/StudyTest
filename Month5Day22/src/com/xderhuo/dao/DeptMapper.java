package com.xderhuo.dao;

import com.xderhuo.domain.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface DeptMapper extends Mapper<Dept> {

    @Select("select * from dept where deptno=#{deptno}")
    Dept findDeptWithId(@Param("deptno") Integer deptno);
}
