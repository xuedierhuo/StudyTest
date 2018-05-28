package com.xderhuo.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Book;
import com.xderhuo.service.BookService;
import com.xderhuo.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    public String findAll(){
        List<Book> books = bookService.findAll();
        getRequest().setAttribute("bookList",books);
        return "/book/list.jsp";
    }

    /**
     * 点击借阅
     * @return
     */
    public String loan(){
        String bookid = getRequest().getParameter("bookid");
        Book book = bookService.findBookById(bookid);
        getRequest().setAttribute("book",book);
        return "book/loan.jsp";
    }

    /**
     * 数量判断
     */
    public void checkNum() throws IOException {
        String bookid = getRequest().getParameter("bookid");
        Book bookById = bookService.findBookById(bookid);
        if (bookById.getNumber() >= Integer.parseInt(getRequest().getParameter("loanNumber"))){
            getResponse().getWriter().print("yes");
        }else {
            getResponse().getWriter().print("no");
        }
    }
}
