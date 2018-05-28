package com.xderhuo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Express;
import com.xderhuo.mapper.ExpressMapper;
import com.xderhuo.service.ExpressService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

public class ExpressServiceImpl implements ExpressService {

    @Override
    public void add(Express express) {
        ExpressMapper expressMapper = MyBatisUtils.getMapper(ExpressMapper.class);
        expressMapper.insert(express);
        MyBatisUtils.commitAndClose();
    }

    @Override
    public PageInfo<Express> findAll(Integer page, Integer rows) {
        ExpressMapper expressMapper = MyBatisUtils.getMapper(ExpressMapper.class);
        PageHelper.startPage(page,rows);
        List<Express> expresses = expressMapper.selectAll();
        MyBatisUtils.close();
        return new PageInfo<>(expresses);
    }

    @Override
    public void deleteById(String id) {
        ExpressMapper expressMapper = MyBatisUtils.getMapper(ExpressMapper.class);
        Express express = new Express();
        express.setEid(Integer.parseInt(id));
        expressMapper.deleteByPrimaryKey(express);
        MyBatisUtils.commitAndClose();
    }

}
