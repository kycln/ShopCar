package com.bbu.dao;

import java.util.ArrayList;

import com.bbu.model.User;

public interface dao {
	//检查用户是否可以登录
	public boolean checkLogin(String sql,String[] parameters);
	//按名字查询用户
	public User getUserByName(String name);
	//注册用户
	public boolean addUser(User user);
}
