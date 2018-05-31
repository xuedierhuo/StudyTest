package com.xderhuo.servlet;

import cn.itcast.servlet.BaseServlet;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Book;
import com.xderhuo.domain.BookBean;
import com.xderhuo.service.BookService;
import com.xderhuo.service.impl.BookServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    public void findAll() throws IOException {
        Integer page = Integer.valueOf(getRequest().getParameter("page"));
        Integer rows = Integer.valueOf(getRequest().getParameter("rows"));
        PageInfo<Book> pageInfo = bookService.findAll(page, rows);
        BookBean bookBean = new BookBean();
        bookBean.setRows(pageInfo.getList());
        bookBean.setTotal(pageInfo.getTotal());

        String s = JSONObject.fromObject(bookBean).toString();
        getResponse().getWriter().print(s);
    }
}
