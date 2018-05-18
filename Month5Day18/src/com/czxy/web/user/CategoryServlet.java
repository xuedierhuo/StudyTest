package com.czxy.web.user;

import java.io.IOException;
import java.util.List;

import com.czxy.domain.Category;
import com.czxy.service.CategoryService;
import com.czxy.service.impl.CategoryServiceImpl;
import com.czxy.utils.MyJsonUtils;

import cn.itcast.servlet.BaseServlet;

/**
 * 前台分类servlet
 * @author liangtong
 *
 */
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ajax查询所有
	 * @throws IOException 
	 */
	public void findAll() throws IOException{
		//1 封装数据
		
		//2 查询
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = categoryService.selectAll();
		
		//3 将java对象转换json数据，响应
		String jsonStr = MyJsonUtils.getJsonString(list);
		this.getResponse().getWriter().print(jsonStr);
	}
}
