package com.hdp.one.mall.web.servlet;

import cn.itcast.servlet.BaseServlet;
import com.hdp.one.mall.pojo.Business;
import com.hdp.one.mall.service.BusinessService;
import com.hdp.one.mall.utils.MyJsonUtils;

import java.io.IOException;
import java.util.List;

/**
 * 商品管理Servlet
 *
 * @author 卢治波
 */
public class BusinessServlet extends BaseServlet {

    /**
     * 定义字段
     */
    private BusinessService managementService = new BusinessService();

    /**
     * 查询所有数据的方法
     */
    public String findAll() {
        // 在此完成代码
        List<Business> all = managementService.findAll();
        getRequest().setAttribute("listAll",all);
        return "admin/seller_1.jsp";
    }

    /**
     * 搜索方法
     */
    public void search() throws IOException {
        //获取参数
        String me = this.getRequest().getParameter("me");
        String value = this.getRequest().getParameter("value");
        List<Business> businessList = managementService.findSearch(me, value);
        String data = MyJsonUtils.getJsonString(businessList);
        this.getResponse().getWriter().println(data);
    }

    /**
     * 查询方法
     */
    public String findSearch() {
        //收集数据
        Business business = toBean(Business.class);
        //调用方法
        List<Business> search = managementService.search(business);
        this.getRequest().setAttribute("listAll", search);
        return "forward:/admin/seller_1.jsp";
    }
}
