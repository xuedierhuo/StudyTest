package com.xderhuo.controller;

import cn.itcast.servlet.BaseServlet;
import com.xderhuo.domain.Grade;
import com.xderhuo.service.GradeService;
import com.xderhuo.service.impl.GradeServiceImpl;
import com.xderhuo.utils.MyJsonUtils;

import java.io.IOException;
import java.util.List;

public class GradeServlet extends BaseServlet {

    public void findAll() throws IOException {
        GradeService service = new GradeServiceImpl();
        String id = getRequest().getParameter("id");
        List<Grade> grades =  service.findAllById(id);
        String jsonString = MyJsonUtils.getJsonString(grades);
        getResponse().getWriter().print(jsonString);
    }
}
