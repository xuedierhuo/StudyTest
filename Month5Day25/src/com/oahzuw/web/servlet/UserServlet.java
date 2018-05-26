package com.oahzuw.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.oahzuw.domain.Cart;
import com.oahzuw.domain.User;
import com.oahzuw.service.CartService;
import com.oahzuw.service.UserService;

import java.io.IOException;
import java.util.List;

public class UserServlet extends BaseServlet {
    private UserService us = new UserService();
    private CartService cs = new CartService();

    /**
     * 登陆方法
     * @return
     */
    public String join(){
        User user = toBean(User.class);
        User loginUser = us.findAllUser(user);
        if (loginUser==null) {
            this.getRequest().setAttribute("message","用户名密码不匹配");
            return "forward:/index.jsp";
        }
        List<Cart> cartList = (List<Cart>) getRequest().getSession().getAttribute("cartList");
        if (loginUser!=null) {
                // 将用户信息放入session
            this.getRequest().getSession().setAttribute("user",loginUser);
        }
        return "redirect:/ProductServlet?method=findAll";
    }

    /**
     * 注册方法
     * @return
     */
    public String login(){
        User user = toBean(User.class);
        String loginname = user.getLoginname();
        User login = us.login(loginname);
        if (login != null){
            return "forward:/login.jsp";
        }
        us.saveuser(user);
        return "forward:/index.jsp";

    }

    /**
     * 检查用户名是否重复
     */
    public void checkUsername() throws IOException {
        //从前台拿到用户名
        String loginname = this.getRequest().getParameter("loginname");
        User user = us.checkUsername(loginname);
        if (user == null){
            this.getResponse().getWriter().print("{\"message\":\"登陆名可用\",\"exist\":true}");
        }else {
            this.getResponse().getWriter().print("{\"message\":\"登陆名已存在\",\"exist\":false}");
        }
    }
}
