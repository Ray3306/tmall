package com.ps.dao;

import java.util.List;

import com.ps.vo.Img;

public interface IImgDao {

	void addImg(Img img);

	void updateImg(Img img);
	
	List<Img> queryProductSingleImgList(String pid);
	
	List<Img> queryProductDetailImgList(String pid);
}
