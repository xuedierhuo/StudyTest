package com.xderhuo.service.Impl;

import com.xderhuo.dao.EmpMapper;
import com.xderhuo.domain.Emp;
import com.xderhuo.service.EmpService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpMapper empMapper;
    @Override
    public List<Emp> findAll() {
        empMapper = MyBatisUtils.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findAll();
        return emps;
    }

    @Override
    public void add(Emp emp) {
        empMapper = MyBatisUtils.getMapper(EmpMapper.class);
        empMapper.insert(emp);
        MyBatisUtils.commitAndClose();
    }
}
