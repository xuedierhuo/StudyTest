package com.xderhuo.service;

import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Orders;

public interface OrderService {
    void saveOrder(Orders orders);

    PageInfo<Orders> findByUid(String uid, Integer pageNum, Integer pageSize);
}
