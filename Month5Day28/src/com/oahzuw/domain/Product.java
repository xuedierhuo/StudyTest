package com.oahzuw.domain;

import javax.persistence.Id;

public class Product {
	@Id
	private Integer id;
	private String name;
	private String type;
	private String price;

	public Product() {
	}

	public Product(Integer id, String name, String type, String price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
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

}
