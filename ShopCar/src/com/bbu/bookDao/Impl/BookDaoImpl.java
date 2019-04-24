package com.bbu.bookDao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bbu.bookDao.bookDao;
import com.bbu.model.Book;
import com.bbu.utils.SQLHelper;

public class BookDaoImpl implements bookDao{

	@Override
	public ArrayList<Book> getBookByPage(int current, int PageSize) {
		// TODO Auto-generated method stub
		ArrayList<Book> arraylist = new ArrayList<>();
		String sql = "select * from book limit ?,?";
		Integer[] parameters = {current,PageSize};
		ResultSet rs = null;
		rs = SQLHelper.executeQueryByPage(sql, parameters);
		try {
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublish(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setNums(rs.getInt(6));
				book.setImg(rs.getString(7));
				arraylist.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getConn(), SQLHelper.getPs());
		}
		return arraylist;
	}

	@Override
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		Book book = new Book();
		ResultSet rs = null;
		String sql = "select * from book where id = ?";
		Integer[] parameters = {id};
		rs = SQLHelper.exeQuery(sql, parameters);
		try {
			if(rs.next()) {
				book.setId(rs.getInt(1));
				book.setBookname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublish(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setNums(rs.getInt(6));
				book.setImg(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getConn(), SQLHelper.getPs());
		}
		return book;
	}

	@Override
	public Integer getBookCount() {
		// TODO Auto-generated method stub
		Integer count = 0;
		String sql = "select count(*) Count from book";
		String[] parameters = null;
		ResultSet rs = null;
		rs = SQLHelper.exeQuery1(sql, parameters);
		try {
			while(rs.next()) {
				count = rs.getInt("Count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SQLHelper.close(rs, SQLHelper.getConn(), SQLHelper.getPs());
		}
		return count;
	}
	
}
