package com.xderhuo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.dao.OrderItemMapper;
import com.xderhuo.dao.OrderMapper;
import com.xderhuo.domain.OrderItem;
import com.xderhuo.domain.Orders;
import com.xderhuo.service.OrderService;
import com.xderhuo.utils.JdbcUtils;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(Orders orders) {
        try {
            //1.保存订单基本信息
            OrderMapper orderMapper = JdbcUtils.getMapper(OrderMapper.class);
            orderMapper.insert(orders);

            //2.保存订单项
            OrderItemMapper orderItemMapper = JdbcUtils.getMapper(OrderItemMapper.class);
            for (OrderItem orderItem : orders.getOrderItems()) {
                orderItemMapper.insert(orderItem);
            }
            //3.1全部执行提交
            JdbcUtils.commitAndClose();
        }catch (Exception e){
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据uid查询订单并且分页
     * @param uid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Orders> findByUid(String uid, Integer pageNum, Integer pageSize) {
        OrderMapper orderMapper = JdbcUtils.getMapper(OrderMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> orders = orderMapper.findByUid(uid);
        PageInfo<Orders> pageInfo = new PageInfo<>(orders);
        return pageInfo;
    }
}
