package com.xderhuo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.dao.TblUserMapper;
import com.xderhuo.domain.TblUser;
import com.xderhuo.service.TblUserService;
import com.xderhuo.utils.MyBatisUtils;

import java.util.List;

/**
 * @author XDerhuo
 */
public class TblUserServiceImpl implements TblUserService {
    private TblUserMapper userMapper;

    @Override
    public PageInfo<TblUser> findAll(Integer pageNum, Integer pageSize, String name) {
        userMapper = MyBatisUtils.getMapper(TblUserMapper.class);

        PageHelper.startPage(pageNum,pageSize);
        //查询条件
        StringBuilder sb = null;
        if (name!=null && name.trim().length()!=0){
            sb = new StringBuilder("%");
            String[] split = name.split("");
            for (String s : split) {
                sb.append(s).append("%");
            }
        }
        String str = "";
        if (sb != null) {
            str = sb.toString();
        }
        List<TblUser> users = userMapper.findAll(str);
        PageInfo<TblUser> pageInfo = new PageInfo<>(users);

        MyBatisUtils.close();
        return pageInfo;
    }
}
