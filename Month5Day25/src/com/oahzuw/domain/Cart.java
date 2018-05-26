package com.oahzuw.domain;

import org.apache.ibatis.annotations.Param;

import javax.persistence.Column;
import javax.persistence.Id;

public class Cart {
	@Id
	private Integer id;
	private String name;
	private String type;
	private String price;
	private Integer number;
	@Column(name = "user_id")
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Cart() {
	}

	public Cart(Integer id, String name, String type, String price, Integer number) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
