package com.xderhuo.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xderhuo.dao.CategoryMapper;
import com.xderhuo.domain.Category;
import com.xderhuo.service.CategoryService;
import com.xderhuo.utils.JdbcUtils;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> selectAll() {
		//1 获得mapper
		CategoryMapper categoryMapper = JdbcUtils.getMapper(CategoryMapper.class);
		//2 查询所有
		return categoryMapper.selectAll();
	}

	@Override
	public PageInfo<Category> selectAll(Integer pageNum, Integer pageSize) {
		//1 设置分页
		PageHelper.startPage(pageNum, pageSize);
		//2 查询所有含分页
		CategoryMapper categoryMapper = JdbcUtils.getMapper(CategoryMapper.class);
		List<Category> list = categoryMapper.selectAll();
		
		//3 获得详情数据
		return new PageInfo<>(list);
	}

	@Override
	public void insertCategory(Category category) {
		//1 获得mapper
		CategoryMapper categoryMapper = JdbcUtils.getMapper(CategoryMapper.class);
		//2 插入
		categoryMapper.insert(category);
		//3 提交事务
		JdbcUtils.commitAndClose();
	}

	@Override
	public Category selectByPrimaryKey(String cid) {
		//1 获得mapper
		CategoryMapper categoryMapper = JdbcUtils.getMapper(CategoryMapper.class);
		//查询
		return categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public void updateByPrimaryKey(Category category) {
		//1 获得mapper
		CategoryMapper categoryMapper = JdbcUtils.getMapper(CategoryMapper.class);
		//2 编辑
		categoryMapper.updateByPrimaryKey(category);
		//3 提交事务
		JdbcUtils.commitAndClose();
	}

	@Override
	public void deleteByPrimaryKey(String cid) {
		//1 获得mapper
		CategoryMapper categoryMapper = JdbcUtils.getMapper(CategoryMapper.class);
		//2 编辑
		categoryMapper.deleteByPrimaryKey(cid);
		//3 提交事务
		JdbcUtils.commitAndClose();
	}

}
