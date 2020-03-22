package com.ps.dao;

import java.util.List;

import com.ps.vo.Review;

public interface IReviewDao {

	List<Review> queryReviewList(int pid);
}
