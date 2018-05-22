package com.xderhuo.service.Impl;

import com.xderhuo.dao.DeptMapper;
import com.xderhuo.domain.Dept;
import com.xderhuo.service.DeptService;
import com.xderhuo.utils.MyBatisUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        DeptMapper mapper = MyBatisUtils.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.selectAll();
        return depts;
    }

    @Override
    public List<Dept> seach(String dname) {
        String[] split = dname.split("");
        Example example = new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        StringBuilder sb = new StringBuilder("%");
        for (String s : split) {
            sb.append(s).append("%");
        }
        criteria.andLike("dname",sb.toString());

        deptMapper = MyBatisUtils.getMapper(DeptMapper.class);
        List<Dept> depts = deptMapper.selectByExample(example);

        return depts;
    }

}
