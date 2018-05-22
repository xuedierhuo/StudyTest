package com.xderhuo.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xderhuo.dao.ProductMapper;
import com.xderhuo.domain.Product;
import com.xderhuo.service.ProductService;
import com.xderhuo.utils.JdbcUtils;
import tk.mybatis.mapper.entity.Example;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findByNew() {
		//最新：时间排序，且必须上架商品
		ProductMapper productMapper = JdbcUtils.getMapper(ProductMapper.class);
		
		//只查询9条
		PageHelper.startPage(1, 9);
		
		//查询条件
		Example example = new Example(Product.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("pflag","0");
		//example.orderBy("pdate");
		example.setOrderByClause("pdate desc");
		
		return productMapper.selectByExample(example);
	}

	@Override
	public List<Product> findByHot() {
		//最热：以“是否热门”标记和是否上架商品标记，为查询条件，进行时间降序查询。
		ProductMapper productMapper = JdbcUtils.getMapper(ProductMapper.class);
		
		//只查询9条
		PageHelper.startPage(1, 9);
		
		//查询条件
		Example example = new Example(Product.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("pflag","0");
		criteria.andEqualTo("isHot", "1");
		//example.orderBy("pdate");
		example.setOrderByClause("pdate desc");
		
		return productMapper.selectByExample(example);
	}

	@Override
	public PageInfo<Product> findByCid(String cid, Integer pageNum, Integer pageSize) {
		
		//1 获得mapper
		ProductMapper productMapper = JdbcUtils.getMapper(ProductMapper.class);
		
		//2 设置分页
		PageHelper.startPage(pageNum, pageSize);
		
		//3 查询
		Example example = new Example(Product.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("cid", cid);
		List<Product> list = productMapper.selectByExample(example);
		
		//4 创建对象
		return new PageInfo<>(list);
	}

	@Override
	public Product selectByPrimaryKey(String pid) {
		ProductMapper productMapper = JdbcUtils.getMapper(ProductMapper.class);
		return productMapper.selectByPrimaryKey(pid);
	}

}
