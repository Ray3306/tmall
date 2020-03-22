package com.ps.vo;

import java.io.Serializable;

public class Property implements Serializable{

	private int id;
	
	private int cid;
	
	private String name;
	
	private String value;
	
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", cid=" + cid + ", name=" + name + ", value=" + value + "]";
	}

	
}
