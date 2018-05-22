package com.xderhuo.service;

import com.xderhuo.domain.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    List<Dept> seach(String dname);
}
