package com.ps.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.service.IImgService;
import com.ps.vo.Img;

@Controller
public class ImgController {

	@Autowired
	IImgService imgService;
	
	@RequestMapping("/queryProductImgList")
	@ResponseBody
	public Map<String,List<Img>> queryProductImgList(@RequestParam String pid){
		return imgService.queryProductImgList(pid);
	}
}
