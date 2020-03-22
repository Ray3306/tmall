package com.ps.service;

import java.util.List;

import com.ps.vo.Review;

public interface IReviewService {

	List<Review> queryReviewList(int pid);
}
