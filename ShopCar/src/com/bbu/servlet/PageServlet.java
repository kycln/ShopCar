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
import com.bbu.model.User;
import com.bbu.serviceBook.impl.ServiceBookImpl;


/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int pageSize = 9;
		ServiceBookImpl servicebook = new ServiceBookImpl();
        // 获取当前页
        String curpage = request.getParameter("curpage");
        // 获取总数量
        int count = servicebook.getBookCount();
        //字符串转成整型
        int currentPage = Integer.parseInt(curpage);
        // 创建page对象
        Page page = new Page(currentPage, pageSize, count);
        // 获取当前页的数据
        ArrayList<Book> book = servicebook.getBookByPage(currentPage, pageSize);
        //将相关数据存储起来
        request.getSession().setAttribute("Page", page);
        request.setAttribute("book", book);
        //转发
        request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
