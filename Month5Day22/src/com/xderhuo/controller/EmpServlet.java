package com.xderhuo.controller;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Emp;
import com.xderhuo.service.EmpService;
import com.xderhuo.service.Impl.EmpServiceImpl;

import java.util.List;

public class EmpServlet extends BaseServlet {
    private EmpService empService = new EmpServiceImpl();
    public String findAll(){
        List<Emp> all = empService.findAll();
        getRequest().setAttribute("list",all);
        return "emplist.jsp";
    }

    public String add(){
        Emp emp = toBean(Emp.class);
        System.out.println(emp.getDeptno());
        empService.add(emp);
        return "/emp?method=findAll";
    }
}
