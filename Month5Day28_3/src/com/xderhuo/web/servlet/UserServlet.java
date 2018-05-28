package com.xderhuo.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.User;
import com.xderhuo.service.UserService;
import com.xderhuo.service.impl.UserServiceImpl;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public String login(){
        User user = toBean(User.class);
        User u = userService.findUser(user);
        if (u != null){
            //登录成功跳转
            getSession().setAttribute("user",u);
            return "/BookServlet?method=findAll";
        }else {
            //登录失败
            getRequest().setAttribute("msg","账号或密码错误");
            return "index.jsp";
        }
    }
}
