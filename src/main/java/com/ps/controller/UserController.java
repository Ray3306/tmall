package com.ps.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ps.service.IUserService;
import com.ps.tools.JwtUtil;
import com.ps.vo.PageUtil;
import com.ps.vo.ResultVO;
import com.ps.vo.User;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping("/queryUserList")
	@ResponseBody
	public PageUtil<User> queryUserList(@RequestParam int pageSize,@RequestParam int currentPage){
		PageUtil<User> pageUtil=new PageUtil<>();
		pageUtil.setCurrentPage(currentPage);
		pageUtil.setPageSize(pageSize);
		pageUtil=userService.queryUserList(pageUtil);
		pageUtil.getRows().forEach(System.out::println);
		return pageUtil;
	}
	
	@GetMapping("/deleteUserById")
	public void deleteUserById(@RequestParam int id) {
		System.out.println("deleteUserById进来了..."+id);
		userService.deleteUserById(id);
	}
	
	@PostMapping("/updateUser")
	@ResponseBody
	public void updateUser(User user) {
		System.out.println("updateUser :"+user);
		userService.updateUser(user);
	}
	
	@PostMapping(path="/addUser", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResultVO<User> addUser(User user) {
		System.out.println("addUser :"+user);
		int count=userService.addUser(user);
		ResultVO<User> result = new ResultVO<>();
		if(count>0) {
			result.setCode("111");
			result.setMsg("用户名已存在!");
		}else { 
			result.setMsg("用户 "+user.getName()+" 注册成功!");
		}
		return result;
	}
	
	
	@PostMapping(path="/userLogin")
	@ResponseBody
	public ResultVO<User> userLogin(User user,HttpSession session) {
		System.out.println("login :"+user);
		User userInfo=userService.userLogin(user);
		
		ResultVO<User> result = new ResultVO<>();
		if(null==userInfo || !(userInfo.getPassword().equals(user.getPassword()))) {
			result.setCode("000");
			result.setMsg("用户名不存在或密码错误!");
		}else {
			Map<String,Object> claims = new HashMap<>();
			claims.put("username", userInfo.getName());
			String token = JwtUtil.createJwtToken(userInfo.getId()+"", claims);
			userInfo.setPassword("***");
			result.setBody(userInfo);
			result.setToken(token);
		}
		return result;
		
	}
	
}
