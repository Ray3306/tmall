package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.service.IReviewService;
import com.ps.vo.Review;

@Controller
public class ReviewController {

	@Autowired
	IReviewService reviewService;
	
	@RequestMapping("/queryReviewList")
	@ResponseBody
	public List<Review> queryReviewList(@RequestParam int pid) {
		System.out.println("queryReviewList :"+pid);
		return reviewService.queryReviewList(pid);
	}
	
}
