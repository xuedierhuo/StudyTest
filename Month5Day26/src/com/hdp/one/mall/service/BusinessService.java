package com.hdp.one.mall.service;

import com.hdp.one.mall.dao.BusinessMapper;
import com.hdp.one.mall.pojo.Business;
import com.hdp.one.mall.utils.JdbcUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 商品管理服务层
 */
public class BusinessService {

    /**
     * 查询所有的方法
     *
     * @return 返回所有数据
     */
    public List<Business> findAll() {
        //使用工具类
        BusinessMapper mapper = JdbcUtils.getMapper(BusinessMapper.class);
        //使用通用Mapper进行查询
        List<Business> selectAll = mapper.selectAll();
        //返回
        return selectAll;
    }

    /**
     * 搜索
     */
    public List<Business> search(Business business) {
        BusinessMapper mapper = JdbcUtils.getMapper(BusinessMapper.class);

        Example example = new Example(Business.class);
        Example.Criteria criteria = example.createCriteria();
        if (business.getCompanyAddress() != null && business.getCompanyAddress().trim().length()!=0){
            criteria.andEqualTo("companyName",business.getCompanyAddress());
        }
        if (business.getStoreName() != null && business.getStoreName().trim().length()!=0){
            criteria.andEqualTo("storeName",business.getStoreName());
        }
        List<Business> businesses = mapper.selectByExample(example);
        return businesses;
    }

    public List<Business> findSearch(String me, String value) {
        BusinessMapper mapper = JdbcUtils.getMapper(BusinessMapper.class);

        Example example = new Example(Business.class);
        Example.Criteria criteria = example.createCriteria();
        String[] split = value.split("");
        StringBuilder sb = new StringBuilder("%");
        for (String s : split) {
            sb.append(s).append("%");
        }
        criteria.andLike(me,sb.toString());

        List<Business> businesses = mapper.selectByExample(example);
        return businesses;
    }
}
