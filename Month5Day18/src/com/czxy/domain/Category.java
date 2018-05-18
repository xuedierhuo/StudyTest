package com.czxy.domain;

import javax.persistence.Id;

public class Category {
	/*
		#创建分类表
		CREATE TABLE category(
		  cid VARCHAR(32) PRIMARY KEY,		#UUID(唯一字符串)
		  cname VARCHAR(50)
		);
	 */
	@Id
	private String cid;
	private String cname;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
