package com.qyj.domain;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String tid;
    private String name;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * 查询所有的学生
     */
    private List<Student> students = new ArrayList<>();




    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
