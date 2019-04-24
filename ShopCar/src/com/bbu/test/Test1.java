package com.bbu.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.bbu.model.Book;
import com.bbu.model.Page;
import com.bbu.serviceBook.impl.ServiceBookImpl;

class Test1 {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test1() {
		ArrayList<Book> book = new ServiceBookImpl().getBookByPage(0, 12);
		for(int i = 0 ; i < book.size();i++) {
			System.out.println(book.get(i).getAuthor());
		}
		
		System.out.println("sss");
		Page page = new Page(1,12,15);
	}
}
