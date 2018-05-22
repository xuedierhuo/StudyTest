package com.xderhuo.service;

import com.xderhuo.domain.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    void add(Emp emp);
}
