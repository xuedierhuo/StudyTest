package com.xderhuo.web.user;

import java.io.IOException;

import javax.servlet.http.Cookie;


import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.User;
import com.xderhuo.service.UserService;
import com.xderhuo.service.impl.UserServiceImpl;
import com.xderhuo.utils.MyJsonUtils;
import com.xderhuo.vo.MessageVo;

/**
 * 前端用户servlet
 * @author liangtong
 *
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户注册
	 * @return
	 */
	public String register(){
		try {
			//1 封装数据
			User u = toBean(User.class);
			//1.1 服务器端自动生成的数据
			u.setUid(CommonUtils.uuid());
			u.setState(1);
			
			/**服务器端数据校验 start*/
			//1) 常规校验（非空、是否相等、格式是否正确、长度 等）
			String repassword = this.getRequest().getParameter("repassword");
			if(! repassword.equals(u.getPassword())){
				//将用户填写信息回显
				this.getRequest().setAttribute("user", u);
				
				//注册页面进行显示
				this.getRequest().setAttribute("msg", "密码和确认密码不匹配！");
				return "forward:/jsp/register.jsp";
			}
			
			//2) 唯一校验（查询数据库）
			UserService userService = new UserServiceImpl();
			User temp = userService.findByUsername(u.getUsername());
			if(temp != null){
				this.getRequest().setAttribute("user", u);
				this.getRequest().setAttribute("msg", "用户名已被抢注！");
				return "forward:/jsp/register.jsp";
			}
			
			//3) 验证码校验
			// 3.1) 获得session存放的验证码数据
			String sessionCode = (String)this.getSession().getAttribute("sessionCode");
			// 3.2) 获得用户输入信息
			String verifyCode = this.getRequest().getParameter("verifyCode");
			// 3.3) 删除session存放验证码数据，保证一次性（使用一次，就是获得一次）
			this.getSession().removeAttribute("sessionCode");
			
			// 3.4) 比较
			if(sessionCode == null){
				this.getRequest().setAttribute("msg", "验证码无效！");
				return "forward:/jsp/register.jsp";
			}
			if(! sessionCode.equalsIgnoreCase(verifyCode)){
				this.getRequest().setAttribute("msg", "验证码错误！");
				return "forward:/jsp/register.jsp";
			}
			
			
			
			/**服务器端数据校验 end*/
			
			
			//2 用户登录功能
			userService.register(u);
			
			//3.1 注册成功--请求转发到登录页面（注册成功，请登录）
			this.getRequest().setAttribute("msg", "注册成功，请登录");
			return "forward:/jsp/login.jsp";
		} catch (Exception e) {
			//3.2 注册失败--请求转发到注册页面（继续注册）
			this.getRequest().setAttribute("msg", "注册失败，请重试！");
			return "forward:/jsp/register.jsp";
		}
	}
	
	/**
	 * ajax校验用户名
	 * @throws IOException 
	 */
	public void check() throws IOException{
		//1 封装数据
		User u = toBean(User.class);
		
		//2 通过用户校验
		UserService userService = new UserServiceImpl();
		User user = userService.findByUsername( u.getUsername());
		
		//3 响应json数据
		MessageVo messageVo = null;
		if(user == null){
			// 3.1 可用
			messageVo = new MessageVo("用户名可用", 1);
			
		} else {
			// 3.2 不可用 
			messageVo = new MessageVo("用户名不可用", 2);
		}
		String jsonStr = MyJsonUtils.getJsonString(messageVo);
		this.getResponse().getWriter().print(jsonStr);
		
	}
	
	/**
	 * 验证码
	 * @throws IOException 
	 */
	public void verifyCode() throws IOException{
		//1 生成验证码图片，并返回验证码字符串
		String code = this.createVerifyCodeImage();
		//2 将字符串验证码存放到session中
		this.getSession().setAttribute("sessionCode", code);
	}
	
	/**
	 * 用户登陆
	 * @return
	 */
	public String login(){
		//1 封装数据
		User u = toBean(User.class);
		
		//2 登陆功能
		UserService userService = new UserServiceImpl();
		User loginUser = userService.login(u.getUsername(),u.getPassword());
		
		//3处理
		if(loginUser != null){
			
			/**自动登录 start*/
			String autologin = this.getRequest().getParameter("autologin");
			if(autologin != null){		//勾选
				//使用cookie记录用户名和密码 ,例如：jack#1234
				//1) 创建
				Cookie cookie = new Cookie("autologinCookieName",loginUser.getUsername() + "#" + loginUser.getPassword());
				//2) 设置路径
				cookie.setPath("/");
				//3) 设置时间
				cookie.setMaxAge(60*60);
				//4) 添加到响应
				this.getResponse().addCookie(cookie);
			}
			
			/**自动登录 end*/
			
			
			
			//3.1 登陆成功，将用户信息保存session，重定向到首页 （session有对象，表示用户登陆的）
			this.getSession().setAttribute("loginUser", loginUser);
			return "redirect:/index.jsp";
		} else {
			//3.2 登陆失败，将提示信息保存request，请求转发登陆页进行错误显示
			this.getRequest().setAttribute("msg", "用户名或密码不匹配！");
			return "forward:/jsp/login.jsp";
		}
	}
	
	/**
	 * 注销（从哪里来，回哪里去，只是将用户注销(session记录用户信息清除)）
	 * @return
	 */
	public String logout(){
		//1 从哪里来（获得referer请求头）
		String refererURL = this.getRequest().getHeader("referer");
		
		//2 注销
		this.getSession().removeAttribute("loginUser");
		
		//将自动登录cookie删除了
		//1) 创建
		Cookie cookie = new Cookie("autologinCookieName","");
		//2) 设置路径
		cookie.setPath("/");
		//3) 设置时间
		cookie.setMaxAge(0);
		//4) 添加到响应
		this.getResponse().addCookie(cookie);
		
		
		//3 回哪里去(重定向到referer表示路径)
		return "redirect:" + refererURL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
