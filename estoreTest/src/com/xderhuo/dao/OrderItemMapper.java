package com.xderhuo.dao;

import com.xderhuo.domain.OrderItem;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderItemMapper extends Mapper<OrderItem> {
    @Select("select * from orderitem where oid = #{oid}")
    @Results({
            @Result(property = "itemid",column = "itemid"),
            @Result(property = "count",column = "count"),
            @Result(property = "subtotal",column = "subtotal"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "product", one = @One(select = "com.xderhuo.dao.ProductMapper.selectByPrimaryKey") ,column = "pid"),
    })
    List<OrderItem> findOrdersByOid(@Param("oid") String oid);
}
