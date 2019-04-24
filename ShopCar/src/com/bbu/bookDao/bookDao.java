package com.bbu.bookDao;

import java.util.ArrayList;

import com.bbu.model.Book;

public interface bookDao {
	//分页取出商品的个数
	public ArrayList<Book> getBookByPage(int current , int PageSize);
	//按着商品的id寻找商品
	public Book getBookById(Integer id);
	//有多少个商品
	public Integer getBookCount();
}
