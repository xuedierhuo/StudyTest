package com.xderhuo.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.OrderBy;

public class Product {
	/*
	 * CREATE TABLE `product` (
		  `pid` VARCHAR(32) NOT NULL,
		  `pname` VARCHAR(50) DEFAULT NULL,		#商品名称
		  `market_price` DOUBLE DEFAULT NULL,	#商场价
		  
		  `shop_price` DOUBLE DEFAULT NULL,		#商城价
		  `pimage` VARCHAR(200) DEFAULT NULL,	#商品图片路径
		  `pdate` DATE DEFAULT NULL,			#上架时间(创建时间)
		  
		  `is_hot` INT(11) DEFAULT NULL,		#是否热门：0=不热门,1=热门
		  `pdesc` VARCHAR(255) DEFAULT NULL,	#商品描述
		  `pflag` INT(11) DEFAULT 0,			#商品标记：0=未下架(默认值),1=已经下架
		  
		  `cid` VARCHAR(32) DEFAULT NULL,		#分类id
		  PRIMARY KEY (`pid`),
		  KEY `product_fk_0001` (`cid`),
		  CONSTRAINT `product_fk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
		) 
	 */
	@Id
	private String pid;
	private String pname;
	private Double marketPrice;
	
	private Double shopPrice;
	private String pimage;
	private Date pdate;
	
	private Integer isHot;
	@OrderBy("desc")
	private String pdesc;
	private Integer pflag;
	
	private String cid;				//外键 , 提供“增删改”使用
	private Category category;		//查询时封装数据
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getPflag() {
		return pflag;
	}
	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
