package com.bbu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.Book;
import com.bbu.mycar.MyCar;

/**
 * Servlet implementation class MyCarServlet
 */
@WebServlet("/MyCarServlet")
public class MyCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		// 控制乱码
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MyCar mycar = new MyCar();
		String type = request.getParameter("type");
		if(type.equals("add")) {
		String id = request.getParameter("id");
		mycar = (MyCar) request.getSession().getAttribute("mycar");
		boolean flag = mycar.addBook(id);
		PrintWriter out = response.getWriter();
		out.print(flag);
		}else if(type.equals("show")){
			mycar = (MyCar) request.getSession().getAttribute("mycar");
			ArrayList<Book> arraylistByCar = null;
			arraylistByCar = mycar.show();
			request.getSession().setAttribute("arraylistByCar", arraylistByCar);
			request.getRequestDispatcher("mycar.jsp").forward(request, response);
		}else if(type.equals("delete")) {
			String id = request.getParameter("id");
			mycar = (MyCar) request.getSession().getAttribute("mycar");
			mycar.deleteBook(id);
			request.getRequestDispatcher("MyCarServlet?type=show").forward(request, response);
		}
	}

}
