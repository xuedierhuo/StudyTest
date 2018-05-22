package com.xderhuo.web.user;

import java.util.List;


import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Product;
import com.xderhuo.service.ProductService;
import com.xderhuo.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String index(){
		//1 封装数据
		
		//2 查询
		ProductService productService = new ProductServiceImpl();
		//2.1 查询最新 
		List<Product> newProduct = productService.findByNew();
		
		//2.2 查询最热
		List<Product> hotProduct = productService.findByHot();
		
		
		//3 请求转发显示数据
		// 3.1 将数据存放request作用域
		this.getRequest().setAttribute("newProduct", newProduct);
		this.getRequest().setAttribute("hotProduct", hotProduct);
		
		// 3.2 请求转发
		return "forward:/jsp/index.jsp";
	}

}
