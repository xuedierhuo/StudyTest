package com.xderhuo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车对象：用于描述某一个人，购买商品情况。（共花了多少钱，买了多少东西。）
 * @author liangtong
 *
 */
public class Cart {
	//商品的所有列表项，此处选择map快速获得，需要维护购买数量
	private Map<String,CartItem> map = new HashMap<String, CartItem>();
	
	//总计：共花多少钱（所有小计的和）
	private Double total;

	public Double getTotal() {
		//计算：所有小计的和
		double sum = 0;
		for(String key : map.keySet()){
			CartItem cartItem = map.get(key);
			sum += cartItem.getSubtotal();
		}
		total = sum;
		return total;
	}
	
	/**
	 * 添加商品到购物车
	 * 	如果购物车中已经有了商品，数量累加
	 *  如果购物车中没有商品，添加
	 * @param product
	 * @param quantity
	 */
	public void addProduct(Product product , Integer quantity){
		//1 通过商品id，从map获得列表项
		CartItem cartItem = map.get(product.getPid());
		
		//2 如果没有，创建列表项，并添加到map
		if(cartItem == null){
			cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(quantity);
			map.put(product.getPid(), cartItem);
		} else {
			//3 如果有，更新数量(累加)
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
		}
	}
	
	/**
	 * 清空
	 */
	public void clear(){
		map.clear();
	}
	
	/**
	 * 改变数据
	 * @param pid
	 * @param quantity
	 */
	public void changeQuantity(String pid, Integer quantity) {
		//1 通过商品id获得CartItem
		CartItem cartItem = map.get(pid);
		//2 修改数据
		cartItem.setQuantity(quantity);
	}
	
	
	
	
	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}


	public void setTotal(Double total) {
		this.total = total;
	}

	
	
}
