package com.xderhuo.service;

import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Express;

import java.util.List;

public interface ExpressService {
    void add(Express express);

    PageInfo<Express> findAll(Integer page, Integer rows);

    void deleteById(String id);
}
