package com.czxy.web.admin;

import java.io.IOException;

import com.czxy.domain.Category;
import com.czxy.domain.DatagridBean;
import com.czxy.service.CategoryService;
import com.czxy.service.impl.CategoryServiceImpl;
import com.czxy.utils.MyJsonUtils;
import com.czxy.vo.CategoryQuery;
import com.github.pagehelper.PageInfo;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class AdminCategoryServlet
 */
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询所有（不能分页）
	 * @throws IOException
	 */
	public void findAll() throws IOException{
		
		//1 获得分页数据
		CategoryQuery categoryQuery = toBean(CategoryQuery.class);
		
		//2 查询所有
		CategoryService categoryService = new CategoryServiceImpl();
		PageInfo<Category> pageInfo = categoryService.selectAll(categoryQuery.getPage() , categoryQuery.getRows());
		
		//3 .将结果转换成json数据，并响应
		//3.1 需要将查询结果封装成datagrid需要的格式
		DatagridBean<Category> dataGridBean = new DatagridBean<>();
		dataGridBean.setRows(pageInfo.getList());
		dataGridBean.setTotal(pageInfo.getTotal());
		//3.2 将java对象转换json数据
		String jsonStr = MyJsonUtils.getJsonString(dataGridBean);
		//3.3 响应浏览器
		this.getResponse().getWriter().print(jsonStr);
	}
	/**
	 * 添加
	 * @throws IOException
	 */
	public void add() throws IOException{
		//1 获得数据
		Category category = toBean(Category.class);
		//1.1 服务器生成数据 id
		category.setCid(CommonUtils.uuid());
		
		//2 添加分类
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.insertCategory(category);
		
		//3 提示
		this.getResponse().getWriter().print("{\"msg\":\"添加成功\"}");
	}
	
	/**
	 * 编辑前操作
	 * @throws IOException 
	 */
	public void editUI() throws IOException{
		//1 封装数据
		Category c = toBean(Category.class);
		
		//2 查询详情
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.selectByPrimaryKey(c.getCid());
		
		//3 将查询结果转换json，响应浏览器
		String jsonStr = MyJsonUtils.getJsonString(category);
		this.getResponse().getWriter().print(jsonStr);
	}

	/**
	 * 编辑操作
	 * @throws IOException
	 */
	public void edit() throws IOException{
		//1 封装数据
		Category category = toBean(Category.class);
		
		//2 编辑操作
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.updateByPrimaryKey(category);
		
		//3 响应
		this.getResponse().getWriter().print("{\"msg\":\"编辑成功\"}");
	}
	
	public void delete() throws IOException{
		//1 封装数据
		Category category = toBean(Category.class);
		
		//2 编辑操作
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.deleteByPrimaryKey(category.getCid());
		
		//3 响应
		this.getResponse().getWriter().print("{\"msg\":\"删除成功\"}");
	}
	
}
