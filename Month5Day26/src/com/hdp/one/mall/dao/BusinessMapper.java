
package com.hdp.one.mall.dao;

import com.hdp.one.mall.pojo.Business;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * 商品管理的数据层
 */
public interface BusinessMapper extends Mapper<Business> {
}