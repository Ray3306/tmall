package com.ps.vo;

import java.io.Serializable;

public class Img implements Serializable{

	private int id;
	
	private int cid;
	
	private int pid;
	
	private String path;
	
	private String type;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Img [id=" + id + ", cid=" + cid + ", pid=" + pid + ", path=" + path + ", type=" + type + "]";
	}

}
