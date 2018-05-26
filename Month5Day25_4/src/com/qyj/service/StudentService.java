package com.qyj.service;

import com.qyj.dao.StudentMapper;
import com.qyj.domain.Student;
import com.qyj.utils.JdbcUtils;

import java.util.List;

public class StudentService {
    /**
     * 查询所有的学生
     * @return
     */
    public List<Student> findAllStudent() {
        StudentMapper mapper = JdbcUtils.getMapper(StudentMapper.class);
        return mapper.selectAll();
    }
}
