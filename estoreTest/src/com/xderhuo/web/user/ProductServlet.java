package com.xderhuo.web.user;

import com.github.pagehelper.PageInfo;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Product;
import com.xderhuo.service.ProductService;
import com.xderhuo.service.impl.ProductServiceImpl;

/**
 * 前台商品管理
 * @author liangtong
 *
 */
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 根据分类id查询所有商品
	 * @return
	 */
	public String findByCid(){
		//1 获得数据
		// 1.1 获得分类id
		String cid = this.getRequest().getParameter("cid");
		// 1.2 获得分页--当前页
		String pageNumStr = this.getRequest().getParameter("pageNum");
		Integer pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {
		}
		// 1.3 准备分页--每页显示个数
		Integer pageSize = 12; 	//固定值
		
		//2 查询
		ProductService productService = new ProductServiceImpl();
		PageInfo<Product> pageInfo = productService.findByCid(cid,pageNum,pageSize);
		//3 响应
		// 3.1 将查询结果存放request
		this.getRequest().setAttribute("pageInfo", pageInfo);
		
		// 3.2 请求转发
		return "forward:/jsp/product_list.jsp";
	}
	
	/**
	 * 通过id查询详情
	 * @return
	 */
	public String findById(){
		//1 封装数据
		Product p = toBean(Product.class);
		//2 查询
		ProductService productService = new ProductServiceImpl();
		Product product = productService.selectByPrimaryKey(p.getPid());
		
		//3 显示
		// 3.1 将查询结果存放request作用域
		this.getRequest().setAttribute("product", product);
		// 3.2 请求转发
		return "forward:/jsp/product_info.jsp";
	}
	
	
	
}
