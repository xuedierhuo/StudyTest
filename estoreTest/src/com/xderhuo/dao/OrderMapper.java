package com.xderhuo.dao;

import com.xderhuo.domain.Orders;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<Orders> {
    @Select("select * from orders where uid = #{uid}")
    @Results({
        @Result(property="oid" , column="oid"),
        @Result(property="ordertime" , column="ordertime"),
        @Result(property="total" , column="total"),
        @Result(property="state" , column="state"),
        @Result(property="address" , column="address"),
        @Result(property="name" , column="name"),
        @Result(property="telephone" , column="telephone"),
        @Result(property="uid" , column="uid"),
        @Result(property = "user" , one = @One(select = "com.xderhuo.dao.UserMapper.selectByPrimaryKey") , column = "uid"),
        @Result(property = "orderItems", many = @Many(select = "com.xderhuo.dao.OrderItemMapper.findOrdersByOid"), column = "oid")
    })
    List<Orders> findByUid(@Param("uid") String uid);
}
