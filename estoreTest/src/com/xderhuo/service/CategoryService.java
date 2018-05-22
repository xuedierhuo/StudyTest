package com.xderhuo.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Category;

public interface CategoryService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<Category> selectAll();

	/**
	 * 查询所有含分页
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Category> selectAll(Integer pageNum, Integer pageSize);

	/**
	 * 插入分类
	 * @param category
	 */
	public void insertCategory(Category category);

	/**
	 * 通过主键查询详情
	 * @param cid
	 * @return
	 */
	public Category selectByPrimaryKey(String cid);

	/**
	 * 根据主键进行编辑
	 * @param category
	 */
	public void updateByPrimaryKey(Category category);

	/**
	 * 根据主键进行删除
	 * @param cid
	 */
	public void deleteByPrimaryKey(String cid);

}
