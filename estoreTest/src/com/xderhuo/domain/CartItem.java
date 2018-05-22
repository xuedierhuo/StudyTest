package com.xderhuo.domain;

/**
 * 购物车列表项对象：用于描述某一件商品的购买情况（xx商品，购买了几件，共花了多少钱）
 * @author liangtong
 *
 */
public class CartItem {
	//购买的商品对象
	private Product product;
	
	//购买数量
	private Integer quantity;
	
	//小计（购买商品单价 * 购买数量）
	private Double subtotal;

	
	public Double getSubtotal() {
		//计算获得
		subtotal = product.getShopPrice() * quantity;
		return subtotal;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
