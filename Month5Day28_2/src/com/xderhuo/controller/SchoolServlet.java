package com.xderhuo.controller;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.School;
import com.xderhuo.service.SchoolService;
import com.xderhuo.service.impl.SchoolServiceImpl;

import java.util.List;

public class SchoolServlet extends BaseServlet {
    /**
     * 初始查询所有
     * @return
     */
    public String findAll(){
        SchoolService schoolService = new SchoolServiceImpl();
        List<School> schools =  schoolService.findAll();
        getRequest().setAttribute("schools",schools);
        return "product.jsp";
    }
}
