package com.oahzuw.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.oahzuw.domain.Cart;
import com.oahzuw.domain.Product;
import com.oahzuw.domain.User;
import com.oahzuw.service.CartService;
import com.oahzuw.service.ProductService;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CartServlet extends BaseServlet {
    private CartService cs = new CartService();
    private ProductService ps = new ProductService();



    /**
     * 添加商品
     * @return
     */
    public String add() throws UnsupportedEncodingException {
        getRequest().setCharacterEncoding("UTF-8");
        // 在此处完成代码
        String name = new String(getRequest().getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(name);
        Product product = ps.selectByName(name);
        User user = (User) getSession().getAttribute("user");

        //两种情况
        List<Cart> list = null;
        if (user == null){
            //游客
            list = (List<Cart>) this.getRequest().getSession().getAttribute("list");
        }else {
            //登录
            list = cs.findAllByUser(user.getUid());
        }

        Cart cart = new Cart();
        cart.setName(product.getName());
        cart.setPrice(product.getPrice());
        cart.setType(product.getType());
        cart.setUserid(user.getUid());
        cart.setNumber(1);

        //存入
        boolean flag = true;
        for (Cart c : list) {
            //如果里面存在这个，那就直接把数量加一
            if (c.getName().equals(cart.getName())){
                cs.updateCartNumber(c.getName(),user.getUid());
                flag = false;
            }
        }
        //不存在直接添加
        if (flag){
            cs.addCart(cart);
        }
        return "/ProductServlet?method=findAll";
    }

    /**
     * 查看购物车,游客模式或者登陆模式
     * @return
     */
    public String look() {
        //判断用户是否登陆
        User user = (User) this.getRequest().getSession().getAttribute("user");
        if (user == null){
            List<Cart> list = (List<Cart>) this.getRequest().getSession().getAttribute("list");
            this.getRequest().setAttribute("carts",list);
            return "forward:/cartList.jsp";
        }else {
            List<Cart> cartList = cs.findAllByUser(user.getUid());
            this.getRequest().setAttribute("carts",cartList);
            return "forward:/cartList.jsp";
        }


    }

    /**
     * 删除购物车方法
     */
    public String delete() throws UnsupportedEncodingException {
        // 在此处完成代码
        String name = new String(getRequest().getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        User user = (User) getSession().getAttribute("user");
        if (user == null){
            //如果是游客
            List<Cart> list = (List<Cart>) getSession().getAttribute("list");
            for (Cart cart : list) {
                if (cart.getName().equals(name)){
                    list.remove(cart);
                }
            }
            getSession().setAttribute("list",list);
        }else {
            //如果是登录用户
            cs.deleteByName(name,user.getUid());
        }
        return "/CartServlet?method=look";
    }
}
