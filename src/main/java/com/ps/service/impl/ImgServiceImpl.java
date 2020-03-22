package com.ps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IImgDao;
import com.ps.service.IImgService;
import com.ps.vo.Img;

@Service
public class ImgServiceImpl implements IImgService {

	@Autowired
	IImgDao imgDao;
	
	@Override
	public Map<String, List<Img>> queryProductImgList(String pid) {
		List<Img> single=imgDao.queryProductSingleImgList(pid);
		List<Img> detail=imgDao.queryProductDetailImgList(pid);
		Map<String,List<Img>> map=new HashMap<>();
		map.put("single", single);
		map.put("detail", detail);
		
		single.forEach(System.out::println);
		System.out.println("-----------------");
		detail.forEach(System.out::println);
		
		return map;
	}

}
