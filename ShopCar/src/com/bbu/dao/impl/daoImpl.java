package com.bbu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bbu.dao.dao;
import com.bbu.model.User;
import com.bbu.utils.SQLHelper;

public class daoImpl implements dao{

	public boolean checkLogin(String sql, String[] parameters) {
		// TODO Auto-generated method stub
		boolean flag = false;
		ResultSet rs = null;
		rs = SQLHelper.exeQuery1(sql, parameters);
		try {
			if(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getConn(), SQLHelper.getPs());
		}
		return flag;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		User user = new User();
		String sql = "select * from user where username = ?";
		String[] parameters = {name};
		ResultSet rs = null;
		rs = SQLHelper.exeQuery1(sql, parameters);
		try {
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setTelephone(rs.getString(5));
				user.setGrade(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getConn(), SQLHelper.getPs());
		}
		return user;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into user values(0,?,?,?,?,2)";
		String[] parameters = {user.getUsername(),user.getPassword(),user.getEmail(),user.getTelephone()};
		SQLHelper.execute(sql, parameters);
		return true;
	}

}
