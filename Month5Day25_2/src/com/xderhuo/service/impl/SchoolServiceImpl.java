package com.xderhuo.service.impl;

import com.xderhuo.domain.School;
import com.xderhuo.mapper.SchoolMapper;
import com.xderhuo.service.SchoolService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {

    @Override
    public List<School> findAll() {
        SchoolMapper schoolMapper = MyBatisUtils.getMapper(SchoolMapper.class);
        List<School> schools = schoolMapper.selectAll();
        return schools;
    }
}
