package com.xderhuo.web.user;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.*;
import com.xderhuo.service.OrderService;
import com.xderhuo.service.impl.OrderServiceImpl;

import java.util.Date;
import java.util.Map;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    public String saveOrder(){
        //1.准备数据
        //1.1获取
        Cart cart = (Cart) getSession().getAttribute("cart");
        //1.2登录用户
        User user = (User) getSession().getAttribute("loginUser");
        if (user==null){
            getRequest().setAttribute("msg","请先登录");
            return "/jsp/login.jsp";
        }
        //1.3封装Orders
        Orders orders = new Orders();
        orders.setOid(CommonUtils.uuid().toString());
        orders.setOrdertime(new Date());
        orders.setTotal(cart.getTotal());
        orders.setState(1);

        orders.setUser(user);
        orders.setUid(user.getUid());

        //订单项，来自购物车的列表项
        Map<String, CartItem> map = cart.getMap();
        for (CartItem cartItem : map.values()) {
            OrderItem orderItem = new OrderItem();
            //将购物车列项中的数据转换到订单中
            orderItem.setItemid(CommonUtils.uuid().toString());
            orderItem.setCount(cartItem.getQuantity());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setPid(cartItem.getProduct().getPid());
            orderItem.setOrder(orders);
            orderItem.setOid(orders.getOid());

            orders.getOrderItems().add(orderItem);
        }
        //2.操作
        orderService.saveOrder( orders );
        cart.clear();
        //3.显示
        getRequest().setAttribute("orders",orders);
        return "/jsp/order_info.jsp";
    }

    public String findByUid(){
        User loginUser = (User) getSession().getAttribute("loginUser");

        if (loginUser==null){
            getRequest().setAttribute("msg","请先登录");
            return "/jsp/login.jsp";
        }
        //分页参数
        String pageNumStr = getRequest().getParameter("pageNum");
        Integer pageNum = 1;
        try {
            pageNum = Integer.parseInt(pageNumStr);
        }catch (Exception e){
        }
        Integer pageSize = 2;

        PageInfo<Orders> pageInfo =  orderService.findByUid(loginUser.getUid(),pageNum,pageSize);
        getRequest().setAttribute("pageInfo",pageInfo);

        //动态分页
        int begin = 1;
        int end = 5;

        if (pageInfo.getPages() < 5){
            end = pageInfo.getPages();
        }else {
            begin = pageInfo.getPageNum()-2;
            end = pageInfo.getPageNum()+2;

            //逻辑判断
            if (begin < 1 ){
                begin = 1;
                end = 5;
            }

            if (end > pageInfo.getPages()){
                end = pageInfo.getPages();
                begin = end - 4;
            }
        }

        getRequest().setAttribute("begin",begin);
        getRequest().setAttribute("end",end);
        return "/jsp/order_list.jsp";
    }

}
