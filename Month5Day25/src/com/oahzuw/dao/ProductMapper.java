package com.oahzuw.dao;

import com.oahzuw.domain.Cart;
import com.oahzuw.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;


public interface ProductMapper  extends Mapper<Product>{


    /**
     * 商品展示
     */
    @Select("select * from product")
    public List<Product> show();


    /**
     * 通过名称查找商品
     * @param name
     */
    @Select("select * from product where name = #{name}")
    public Product selectByName(String name);
}
