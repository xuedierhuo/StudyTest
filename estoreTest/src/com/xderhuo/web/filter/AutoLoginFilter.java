package com.xderhuo.web.filter;

import com.xderhuo.domain.User;
import com.xderhuo.service.UserService;
import com.xderhuo.service.impl.UserServiceImpl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//0 强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//1 确认放行哪些资源
		String path = request.getServletPath();
		System.out.println(path);
		// 1.1 静态资源不需要登录
		if(path.startsWith("/css") || path.startsWith("/js") || path.startsWith("/img")){
			chain.doFilter(request, response);
			return;
		}
		// 1.2 部分功能（登录、注册、注销）
		if(path.equals("/jsp/register.jsp") || path.equals("/jsp/login.jsp") || path.equals("/CategoryServlet") || path.equals("/UserServlet")){
			chain.doFilter(request, response);
			return;
		}
		
		//2 如果登录，直接放行
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		if(loginUser != null){
			chain.doFilter(request, response);
			return;
		}
		
		//3 如果没有登录，获得自动登录cookie，如果没有cookie，放行
		Cookie[] allCookie = request.getCookies();
		Cookie cookie = null;
		if(allCookie != null){
			for(Cookie c : allCookie){
				if(c.getName().equals("autologinCookieName")){
					cookie = c;
				}
			}
		}
		// 没有cookie
		if(cookie == null){
			chain.doFilter(request, response);
			return;
		}
		
		//4 如果有cookie，进行用户登录功能，没有登录成功，放行
		String cookieValue = cookie.getValue();		//例如：jack#1234
		int index = cookieValue.indexOf("#");
		String username = cookieValue.substring(0, index);
		String password = cookieValue.substring(index + 1);
		
		UserService userService = new UserServiceImpl();
		loginUser = userService.login(username, password);
		
		//没有登录成功，放行
		if(loginUser == null){
			chain.doFilter(request, response);
			return;
		}
		
		//5 有cookie，登录成功，【登录用户添加到session】，放行
		request.getSession().setAttribute("loginUser", loginUser);
		//放行
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
