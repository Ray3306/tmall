package com.ps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IReviewDao;
import com.ps.service.IReviewService;
import com.ps.vo.Review;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	IReviewDao reviewDao;
	
	@Override
	public List<Review> queryReviewList(int pid) {
		return reviewDao.queryReviewList(pid);
	}

}
