package com.ps.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ps.tools.JsonDateTypeConvert;

public class Order implements Serializable{

	//订单id
	private int id;
	
	//订单号
	private String orderCode;
	
	//收货地址
	private String address;
	
	//邮件号
	private String post;
	
	//收货人
	private String receiver;
	
	//用户电话
	private String mobile;
	
	//用户留言
	private String userMessage;
	
	//订单生成时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") 
	private Date createDate;
	
	//支付时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date payDate;
	
	//发货时间
	private Date deliveryDate;
	
	//订单完成时间
	private Date confirmDate;
	
	//订单状态
	private String status;
	
	//用户id
	private int uid;
	
	//订单总金额
	private double money;
	
	//订单总数
	private int number;
	
	//用户姓名
	private String name;
	
	
	private List<Product> productList;
	

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	@JsonSerialize(using = JsonDateTypeConvert.class)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonSerialize(using = JsonDateTypeConvert.class)
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@JsonSerialize(using = JsonDateTypeConvert.class)
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@JsonSerialize(using = JsonDateTypeConvert.class)
	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ", address=" + address + ", post=" + post
				+ ", receiver=" + receiver + ", mobile=" + mobile + ", userMessage=" + userMessage + ", createDate="
				+ createDate + ", payDate=" + payDate + ", deliveryDate=" + deliveryDate + ", confirmDate="
				+ confirmDate + ", status=" + status + ", uid=" + uid + ", money=" + money + ", number=" + number
				+ ", name=" + name + ", productList=" + productList + "]";
	}

	
}
