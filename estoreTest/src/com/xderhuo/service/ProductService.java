package com.xderhuo.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xderhuo.domain.Product;

public interface ProductService {

	/**
	 * 最新商品
	 * @return
	 */
	List<Product> findByNew();

	/**
	 * 最热商品
	 * @return
	 */
	List<Product> findByHot();

	/**
	 * 查询指定分类所有商品（含分页）
	 * @param cid 分类id
	 * @param pageNum 第几页
	 * @param pageSize 每页显示个数
	 * @return
	 */
	PageInfo<Product> findByCid(String cid, Integer pageNum, Integer pageSize);

	/**
	 * 通过主键查询详情
	 * @param pid
	 * @return
	 */
	Product selectByPrimaryKey(String pid);

}
