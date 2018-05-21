package com.xderhuo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.dao.TblUserMapper;
import com.xderhuo.domain.TblUser;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

/**
 * @author XDerhuo
 */
public interface TblUserService {

    PageInfo<TblUser> findAll(Integer pageNum, Integer pageSize);
}
