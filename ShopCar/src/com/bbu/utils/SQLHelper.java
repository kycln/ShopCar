package com.bbu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SQLHelper {
	private static Connection conn;
	private static PreparedStatement pstate;
	private static ResultSet rs;
	private static String driver;
	private static String user;
	private static String password;
	private static String url;
	private static InputStream fio;
	private static Properties pro;
	static {
		try {
			pro = new Properties();
			fio = SQLHelper.class.getClassLoader().getResourceAsStream("info.properties");
			pro.load(fio);
			driver = pro.getProperty("driver");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			Class.forName(driver);
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally {
			// TODO: handle finally claus
			try {
				if(null != fio) {
				fio.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		try {
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static Connection getConn() {
		return conn;
	}
	public static ResultSet getRs() {
		return rs;
	}
	public static PreparedStatement getPs() {
		return pstate;
	}
	public static void close(ResultSet rs , Connection conn , PreparedStatement ps) {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null != ps) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static ResultSet exeQuery(String sql , Integer[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for(int i=0 ; i<parameters.length ; i++) {
					pstate.setInt(i+1, parameters[i]);
			}
			}
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet exeQuery1(String sql , String[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for(int i=0 ; i<parameters.length ; i++) {
					pstate.setString(i+1, parameters[i]);
			}
			}
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void execute(String sql , String[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for(int i = 0 ; i < parameters.length;i++) {
					pstate.setString(i+1, parameters[i]);
				}
			}
			pstate.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, conn, pstate);
		}
	}
	public static ResultSet executeQueryByPage(String sql , Integer[] parameters) {
		try {
			conn = getConnection();
			pstate = (PreparedStatement) conn.prepareStatement(sql);
			if(null != parameters) {
				for (int i = 0;i < parameters.length;i++) {
					pstate.setInt(i+1, parameters[i]);
				}
				rs = pstate.executeQuery();	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
