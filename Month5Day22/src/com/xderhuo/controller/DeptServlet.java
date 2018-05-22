package com.xderhuo.controller;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Dept;
import com.xderhuo.service.DeptService;
import com.xderhuo.service.Impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author XDerhuo
 */
@WebServlet(name = "DeptServlet")
public class DeptServlet extends BaseServlet {
    private DeptService deptService = new DeptServiceImpl();

    public String index(){
        List<Dept> all = deptService.findAll();
        getRequest().setAttribute("list",all);
        return "deptlist.jsp";
    }

    public String findDeptList(){
        String dname = getRequest().getParameter("dname");
        List<Dept> depts = deptService.seach(dname);
        getRequest().setAttribute("list",depts);
        return "deptlist.jsp";
    }

    public String toAdd(){
        List<Dept> all = deptService.findAll();
        getRequest().setAttribute("list",all);
        return "addemp.jsp";
    }
}
