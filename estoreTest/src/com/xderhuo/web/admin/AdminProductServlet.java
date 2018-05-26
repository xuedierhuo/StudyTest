package com.xderhuo.web.admin;

import cn.itcast.servlet.BaseServlet;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.DatagridBean;
import com.xderhuo.domain.Product;
import com.xderhuo.service.ProductService;
import com.xderhuo.service.impl.ProductServiceImpl;
import com.xderhuo.utils.MyJsonUtils;
import com.xderhuo.vo.ProductQuery;

import java.io.IOException;

public class AdminProductServlet extends BaseServlet {
    public void findAll() throws IOException {
        //1.分页数据获得
        ProductQuery productQuery = toBean(ProductQuery.class);

        //2.查询所有（分页）
        ProductService productService = new ProductServiceImpl();
        PageInfo<Product> dataInfo = productService.findAll(productQuery.getPage(),productQuery.getRows());

        //3.响应成json
        DatagridBean<Product> datagridBean = new DatagridBean<>();
        datagridBean.setTotal(dataInfo.getTotal());
        datagridBean.setRows(dataInfo.getList());
        String jsonString = MyJsonUtils.getJsonString(datagridBean);
        getResponse().getWriter().print(jsonString);
    }
}
