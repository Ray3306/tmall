package com.ps.service;

import com.ps.vo.PageUtil;
import com.ps.vo.User;

public interface IUserService {

	PageUtil<User> queryUserList(PageUtil<User> pageUtil);

	void deleteUserById(int id);

	void updateUser(User user);

	int addUser(User user);

	User userLogin(User user);
	
	
}
