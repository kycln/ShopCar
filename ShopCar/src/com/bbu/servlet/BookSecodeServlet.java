package com.bbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.Book;
import com.bbu.model.Page;
import com.bbu.serviceBook.impl.ServiceBookImpl;

/**
 * Servlet implementation class BookSecodeServlet
 */
@WebServlet("/BookSecodeServlet")
public class BookSecodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.getSession().setAttribute("Page", new Page(1,12,new ServiceBookImpl().getBookCount()));
		ArrayList<Book> book = new ServiceBookImpl().getBookByPage(0, 12);
		request.setAttribute("book", book);
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
