package com.xderhuo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.dao.TblUserMapper;
import com.xderhuo.domain.TblUser;
import com.xderhuo.service.TblUserService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

/**
 * @author XDerhuo
 */
public class TblUserServiceImpl implements TblUserService {
    private TblUserMapper userMapper;

    @Override
    public PageInfo<TblUser> findAll(Integer pageNum, Integer pageSize) {
        userMapper = MyBatisUtils.getMapper(TblUserMapper.class);

        PageHelper.startPage(pageNum,pageSize);
        List<TblUser> users = userMapper.selectAll();
        PageInfo<TblUser> pageInfo = new PageInfo<>(users);

        MyBatisUtils.close();
        return pageInfo;
    }
}
