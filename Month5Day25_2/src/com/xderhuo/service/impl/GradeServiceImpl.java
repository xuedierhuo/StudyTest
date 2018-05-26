package com.xderhuo.service.impl;

import com.xderhuo.domain.Grade;
import com.xderhuo.mapper.GradeMapper;
import com.xderhuo.service.GradeService;
import com.xderhuo.utils.MyBatisUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    @Override
    public List<Grade> findAllById(String id) {
        GradeMapper gradeMapper = MyBatisUtils.getMapper(GradeMapper.class);
        Example example = new Example(Grade.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("id",id);

        List<Grade> grades = gradeMapper.selectByExample(example);
        return grades;
    }
}
