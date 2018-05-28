package com.oahzuw.service;

import com.oahzuw.dao.CartMapper;
import com.oahzuw.domain.Cart;
import com.oahzuw.domain.User;
import com.oahzuw.utils.JdbcUtils;

import java.util.List;

public class CartService {

    /**
     * 游客模式下购物车展示
     * @return
     */
    public List<Cart> find(){
        CartMapper cartMapper = JdbcUtils.getMapper(CartMapper.class);
        List<Cart> cartList = cartMapper.find();
        JdbcUtils.commitAndClose();
        return cartList;
    }

    /**
     * 通过用户id查询输出其购物车内容
     * @param uid
     * @return
     */
    public List<Cart> findAllByUser(Integer uid) {
        CartMapper cartMapper = JdbcUtils.getMapper(CartMapper.class);
        List<Cart> byId = cartMapper.findById(uid);
        JdbcUtils.commitAndClose();
        return byId;
    }

    /**
     * 登陆模式下更新购物车商品信息
     * @param name
     * @param id
     */
    public void updateCartNumber(String name,Integer id) {
        CartMapper cartMapper = JdbcUtils.getMapper(CartMapper.class);
        cartMapper.updateCartNumber(name,id);
        JdbcUtils.commitAndClose();
    }

    /**
     * 添加购物车
     * @param cart
     */
    public void addCart(Cart cart) {
        CartMapper cartMapper = JdbcUtils.getMapper(CartMapper.class);
        cartMapper.insert(cart);
        JdbcUtils.commitAndClose();
    }

    /**
     * 通过商品名称删除购物车商品
     * @param name
     */
    public void deleteByName(String name,Integer id) {
        CartMapper cartMapper = JdbcUtils.getMapper(CartMapper.class);
        cartMapper.deleteByName(name,id);
        JdbcUtils.commitAndClose();
    }
}
