package com.xderhuo.vo;

/**
 * 所有条件--数据
 * @author liangtong
 *
 */
public class CategoryQuery {
	private Integer page;		//第几页
	private Integer rows;		//每页显示个数
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
}
