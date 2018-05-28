package com.oahzuw.dao;

import com.oahzuw.domain.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CartMapper extends Mapper<Cart>{
    List<Cart> find();

    @Select("select * from cart where user_id = #{uid}")
    List<Cart> findById(@Param("uid") Integer uid);

    @Update("UPDATE cart SET number=number+1 WHERE user_id = #{id} and name = #{name}")
    void updateCartNumber(@Param("name") String name, @Param("id") Integer id);

    @Delete("DELETE FROM `cart` WHERE `name` = #{name} and user_id = #{user_id} ")
    void deleteByName(@Param("name") String name, @Param("user_id") Integer id);
    // 在此处完成代码

}
