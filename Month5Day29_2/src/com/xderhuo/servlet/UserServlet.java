package com.xderhuo.servlet;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Book;
import com.xderhuo.domain.User;
import com.xderhuo.service.UserService;
import com.xderhuo.service.impl.UserServiceImpl;
import jdk.nashorn.internal.ir.IfNode;

import javax.servlet.http.Cookie;

/**
 * @author XDerhuo
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public String login(){
        User user = toBean(User.class);
        User loginuser = userService.login(user);
        if (loginuser==null){
            //登录失败
            getRequest().setAttribute("msg","用户名或密码不正确");
            return "index.jsp";
        }
        getSession().setAttribute("user",loginuser);
        String remberme = getRequest().getParameter("remberme");
        if (remberme!=null){
            //记住我
            Cookie cookie = new Cookie("username",loginuser.getUsername());
            cookie.setMaxAge(60*60);
            cookie.setPath("/");
            getResponse().addCookie(cookie);

            Cookie cookie2 = new Cookie("password",loginuser.getPassword());
            cookie.setMaxAge(60*60);
            cookie.setPath("/");
            getResponse().addCookie(cookie2);
        }else {
            Cookie cookie = new Cookie("username","");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            getResponse().addCookie(cookie);

            Cookie cookie2 = new Cookie("password","");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            getResponse().addCookie(cookie2);
        }

        return "book/list.jsp";
    }
}
