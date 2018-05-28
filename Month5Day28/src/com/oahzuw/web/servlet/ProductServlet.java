package com.oahzuw.web.servlet;



import cn.itcast.servlet.BaseServlet;
import com.oahzuw.domain.Cart;
import com.oahzuw.domain.Product;
import com.oahzuw.domain.User;
import com.oahzuw.service.ProductService;

import java.util.List;


public class ProductServlet extends BaseServlet {
    ProductService productService = new ProductService();
    /**
     * 查看商品列表，游客模式
     * @return
     */
    public String findAll() {
        List<Product> productList = productService.findAll();
        this.getRequest().setAttribute("productList",productList);
        return "forward:/productList.jsp";
    }



}
