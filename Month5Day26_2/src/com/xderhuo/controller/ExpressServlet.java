package com.xderhuo.controller;

import cn.itcast.servlet.BaseServlet;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.DataBean;
import com.xderhuo.domain.Express;
import com.xderhuo.service.ExpressService;
import com.xderhuo.service.impl.ExpressServiceImpl;
import com.xderhuo.utils.MyJsonUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ExpressServlet extends BaseServlet {
    private ExpressService expressService = new ExpressServiceImpl();
    public String add() throws UnsupportedEncodingException {
        Express express = toBean(Express.class);
        expressService.add(express);
        return "/list.jsp";
    }
    public void findExpressPage() throws IOException {
        Integer page = Integer.valueOf(getRequest().getParameter("page"));
        Integer rows = Integer.valueOf(getRequest().getParameter("rows"));
        PageInfo<Express> pageInfo = expressService.findAll(page, rows);
        List<Express> list = pageInfo.getList();
        DataBean<Express> dataBean = new DataBean();
        dataBean.setRows(list);
        dataBean.setTotal(pageInfo.getTotal());
        String jsonString = MyJsonUtils.getJsonString(dataBean);
        getResponse().getWriter().print(jsonString);
    }

    public String deleteExpress(){
        String id = getRequest().getParameter("id");
        expressService.deleteById(id);
        return "/list.jsp";
    }
}
