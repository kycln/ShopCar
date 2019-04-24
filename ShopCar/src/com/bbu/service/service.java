package com.bbu.service;

import com.bbu.model.User;

public interface service {
	/**
	 * 关于User用户的service层，其方法功能和dao层的功能一样
	 */
	public boolean checkLogin(String sql,String[] parameters);
	public User getUserByName(String name);
	public boolean addUser(User user);
}
