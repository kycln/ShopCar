package com.bbu.mycar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.bbu.model.Book;
import com.bbu.serviceBook.impl.ServiceBookImpl;

public class MyCar {
	private HashMap<String, Book> hm = new HashMap<>();

	public HashMap<String, Book> getHm() {
		return hm;
	}
	public void setHm(HashMap<String, Book> hm) {
		this.hm = hm;
	}
	//向购物车里添加书籍
	public boolean addBook(String id) {
		//先判断购物车里是否已经有这本书了
		if (hm.containsKey(id)) {
			Book book = hm.get(id);
			int buyNums = book.getNums();
			book.setNums(buyNums + 1);
			System.out.println(book.getBookname());
			return true;
		} else {
			Integer ids = Integer.valueOf(id);
			Book book = new ServiceBookImpl().getBookById(ids);
			book.setNums(1);
			hm.put(id, book);
			Book book1 = new Book();
			Iterator it = hm.keySet().iterator();
			while(it.hasNext()) {
				String idddd = (String) it.next();
				System.out.println((book1 = hm.get(idddd)).getBookname());
			}	
			return true;
		}
		
	}
	//不喜欢这本书，将这本书从购物车中完全删除
	public void deleteBook(String id) {
		hm.remove(id);
	}
	//显示购物车里面书籍的方法
	public ArrayList<Book> show(){
		ArrayList<Book> arraylist = new ArrayList<>();
		Book book = new Book();
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()) {
			String id = (String) it.next();
			book = hm.get(id);
			arraylist.add(book);
		}
		return arraylist;
	}
	//购物车里面书的价格
	public float AllPrice() {
		float sum = (float) 0.0;
		Book book = new Book();
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()) {
			String id = (String) it.next();
			book = hm.get(id);
			sum = sum + book.getNums()*Float.parseFloat(String.valueOf(book.getPrice()));
		}
		return sum;
	}
}
