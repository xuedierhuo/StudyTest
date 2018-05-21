package com.czxy.servlet;


import java.util.List;

import com.czxy.domain.Book;
import com.czxy.service.BookService;

import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService service = new BookService();
	//查询所有
	public String listBook(){
		List<Book> list = service.selectAll();
		this.getRequest().setAttribute("list", list);
		return "forward:/admin/products/list.jsp";
	}
	
	//根据id查询book信息
	public String viewBook(){
		String id = this.getRequest().getParameter("id");
		Book book = service.selectBookById(id);
		this.getRequest().setAttribute("book", book);
		return "forward:/admin/products/edit.jsp";
	}
	
	//更新数据
	public String updateBook(){
		Book book = toBean(Book.class);
		service.updateBook(book);
		return "redirect:/bookServlet?method=listBook";
	}
	//多条件查询
	public String findProductByManyCondition(){
		//补全代码
		Book book = toBean(Book.class);
		List<Book> books = service.findProductByManyCondition(book);
		getRequest().setAttribute("list",books);


		return "forward:/admin/products/list.jsp";
	}
	
	//删除图书
	public String delBook(){
		 String id = this.getRequest().getParameter("id");
		 service.deleteBookById(id);
		return "redirect:/bookServlet?method=listBook";
	}
	//添加图书
	public String addBook(){
		Book book = toBean(Book.class);
		service.addBook(book);
		return "redirect:/bookServlet?method=listBook";
	}

}
