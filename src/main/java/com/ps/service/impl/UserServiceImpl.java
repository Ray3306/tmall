package com.ps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.dao.IUserDao;
import com.ps.service.IUserService;
import com.ps.vo.PageUtil;
import com.ps.vo.User;
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDao userDao;
	
	@Override
	public PageUtil<User> queryUserList(PageUtil<User> pageUtil) {
		Map<String,Object> map=new HashMap<>();
		map.put("start", pageUtil.getStart());
		map.put("size", pageUtil.getPageSize());
		
		List<User> list=userDao.queryUserList(map);
		int total=userDao.queryUserTotal();
		
		pageUtil.setRows(list);
		pageUtil.setTotal(total);
		return pageUtil;
	}

	@Override
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public int addUser(User user) {
		int count=userDao.checkName(user);
		if(count==0) {
			userDao.addUser(user);
		}
		return count;
	}

	@Override
	public User userLogin(User user) {
		User u=userDao.userLogin(user);
		return u;
	}
	
	

}
