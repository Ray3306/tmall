package com.ps.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Product implements Serializable{

	//产品id
	private int id;
	
	//产品名称
	private String name;
	
	//产品小标题
	private String subTitle;
	
	//初始价格
	private double orignalPrice;
	
	//折后价格
	private double promotePrice;
	
	//库存
	private int stock;
	
	//上架时间
	private Date createDate;
	
	//种类id
	private int cid;
	
	//
	private int number;
	
	//销售总量
	private int saleCount;
	
	//评论数量
	private int reviewCount;
	
	//订单项目关系表id
	private int oiid;
	
	//图片
	private Img img;
	
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", subTitle=" + subTitle + ", orignalPrice=" + orignalPrice
				+ ", promotePrice=" + promotePrice + ", stock=" + stock + ", createDate=" + createDate + ", cid=" + cid
				+ ", number=" + number + ", saleCount=" + saleCount + ", reviewCount=" + reviewCount + ", oiid=" + oiid
				+ ", img=" + img + "]";
	}

	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Img getImg() {
		return img;
	}

	public void setImg(Img img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public double getOrignalPrice() {
		return orignalPrice;
	}

	public void setOrignalPrice(double orignalPrice) {
		this.orignalPrice = orignalPrice;
	}

	public double getPromotePrice() {
		return promotePrice;
	}

	public void setPromotePrice(double promotePrice) {
		this.promotePrice = promotePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	
}
