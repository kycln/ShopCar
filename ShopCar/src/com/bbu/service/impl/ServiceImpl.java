package com.bbu.service.impl;

import com.bbu.dao.impl.daoImpl;
import com.bbu.model.User;
import com.bbu.service.service;

public class ServiceImpl implements service{

	@Override
	public boolean checkLogin(String sql, String[] parameters) {
		// TODO Auto-generated method stub
		
		return new daoImpl().checkLogin(sql, parameters);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return new daoImpl().getUserByName(name);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return new daoImpl().addUser(user);
	}

}
