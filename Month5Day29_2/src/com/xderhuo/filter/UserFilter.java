package com.xderhuo.filter;

import com.xderhuo.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //进行其他资源放行
        if(("/index.jsp".equals(servletPath)) || ("/UserServlet".equals(servletPath)) || (servletPath.contains(".css")) || (servletPath.contains(".png")) || (servletPath.contains(".js")) || (servletPath.contains(".jpg"))){
            filterChain.doFilter(request,response);
            return;
        }
        User user = (User) request.getSession().getAttribute("user");


        if (user == null){
            //没有登录
            //进行跳转
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }else{
            //登录成功
            //放行
            filterChain.doFilter(request,response);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
