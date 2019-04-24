package com.bbu.serviceBook.impl;

import java.util.ArrayList;

import com.bbu.bookDao.Impl.BookDaoImpl;
import com.bbu.model.Book;
import com.bbu.serviceBook.ServiceBook;

public class ServiceBookImpl implements ServiceBook{

	@Override
	public ArrayList<Book> getBookByPage(int current, int PageSize) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().getBookByPage(current, PageSize);
	}

	@Override
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().getBookById(id);
	}

	@Override
	public Integer getBookCount() {
		// TODO Auto-generated method stub
		return new BookDaoImpl().getBookCount();
	}

}
