package com.oahzuw.service;

import com.oahzuw.dao.CartMapper;
import com.oahzuw.dao.ProductMapper;
import com.oahzuw.domain.Cart;
import com.oahzuw.domain.Product;
import com.oahzuw.utils.JdbcUtils;

import java.util.List;

public class ProductService {

    /**
     * 商品展示
     * @return
     */
    public List<Product> findAll() {
        ProductMapper productMapper = JdbcUtils.getMapper(ProductMapper.class);
        return productMapper.show();
    }



    public List<Cart> findAllByUser(Integer uid) {

        return null;
    }

    public Product selectByName(String name) {
        ProductMapper productMapper = JdbcUtils.getMapper(ProductMapper.class);
        Product product = productMapper.selectByName(name);
        return product;
    }

//    public void delete(Integer id) {
//        CartMapper cartMapper = JdbcUtils.getMapper(CartMapper.class);
//        cartMapper.delete(id);
//        JdbcUtils.commitAndClose();
//    }
}
