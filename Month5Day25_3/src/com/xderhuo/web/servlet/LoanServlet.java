package com.xderhuo.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Book;
import com.xderhuo.domain.Loan;
import com.xderhuo.domain.User;
import com.xderhuo.mapper.LoanMapper;
import com.xderhuo.service.LoanService;
import com.xderhuo.service.impl.LoanServiceImpl;

import java.util.Date;
import java.util.List;

public class LoanServlet extends BaseServlet {
    private LoanService loanService = new LoanServiceImpl();

    public String addLoan(){
        int number = Integer.parseInt(getRequest().getParameter("number"));
        int loanNumber = Integer.parseInt(getRequest().getParameter("loanNumber"));
        Book book = toBean(Book.class);
        getRequest().setAttribute("book",book);
        if (number < loanNumber){
            getRequest().setAttribute("msg","馆藏数量不足，最多只能借"+number+"件");
            return "book/loan.jsp";
        }else {
            //借阅成功,封装数据
            Loan loan = new Loan();
            loan.setBookid(book.getBookid());
            loan.setLoannumber(loanNumber);
            User user = (User) getSession().getAttribute("user");
            loan.setUid(user.getUid());
            loan.setLoantime(new Date());
            //---------------
            loanService.addLoan(loan);

            List<Loan> loans = loanService.findLoanByUid(user.getUid());
            getRequest().setAttribute("loanList", loans);
            return "book/loanDetail.jsp";
        }
    }
}
