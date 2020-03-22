package com.ps.dao;

import java.util.List;
import java.util.Map;

import com.ps.vo.User;

public interface IUserDao {

	//用户信息List查询
	List<User> queryUserList(Map map);
	
	int queryUserTotal();

	//用户信息删除(admin)
	void deleteUserById(int id);

	//用户信息修改(admin)
	void updateUser(User user);

	//用户注册
	void addUser(User user);
	
	//用户注册重名验证
	int checkName(User user);

	//用户登录验证
	User userLogin(User user);
}
