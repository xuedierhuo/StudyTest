package com.qyj.service;

import com.qyj.dao.TeacherMapper;
import com.qyj.domain.Teacher;
import com.qyj.utils.JdbcUtils;

import java.util.List;

public class TeacherService {
    /**
     * 查询所有的老师
     * @return
     */
    public List<Teacher> findAllTeacher() {
        TeacherMapper mapper = JdbcUtils.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.selectAll();
        JdbcUtils.release();
        return teachers;
    }
}
