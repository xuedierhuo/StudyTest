package com.xderhuo.controller;

import cn.itcast.servlet.BaseServlet;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.DatagridBean;
import com.xderhuo.domain.TblUser;
import com.xderhuo.service.TblUserService;
import com.xderhuo.service.impl.TblUserServiceImpl;
import com.xderhuo.utils.MyJsonUtils;
import com.xderhuo.vo.UserQuery;

import java.io.IOException;
import java.util.List;

/**
 * @author XDerhuo
 */
public class TblUserController extends BaseServlet {
    private TblUserService userService = new TblUserServiceImpl();

    public void findAll() throws IOException {
        UserQuery userQuery = toBean(UserQuery.class);
        PageInfo<TblUser> userInfo = userService.findAll(userQuery.getPage(), userQuery.getRows() , userQuery.getName());

        DatagridBean<TblUser> datagridBean = new DatagridBean<>();
        datagridBean.setRows(userInfo.getList());
        datagridBean.setTotal(userInfo.getTotal());

        String jsonString = MyJsonUtils.getJsonString(datagridBean);
        System.out.println(jsonString);
        getResponse().getWriter().print(jsonString);
    }

    /**
     * 查询
     */
//    public void search() throws IOException {
//        String username = getRequest().getParameter("username");
//        List<TblUser> users = userService.seach(username);
//
//        getResponse().getWriter().print();
//    }
}
