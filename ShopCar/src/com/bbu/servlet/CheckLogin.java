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
import com.bbu.mycar.MyCar;
import com.bbu.service.impl.ServiceImpl;
import com.bbu.serviceBook.impl.ServiceBookImpl;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 控制乱码
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		User user = (User) request.getSession().getAttribute("user");
		if (null != user) {
			MyCar mycar = new MyCar();
			request.getSession().setAttribute("mycar", mycar);
			request.getSession().setAttribute("Page", new Page(1,12,new ServiceBookImpl().getBookCount()));
			ArrayList<Book> book = new ServiceBookImpl().getBookByPage(0, 12);
			request.setAttribute("book", book);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 验证码的使用
			String vcode = request.getParameter("vcode");
			// 获取图片上验证码的值
			String cscode = (String) request.getSession().getAttribute("vscode");
			String[] parameters = { username, password };
			String sql = "select * from user where username = ? and password = ?";
			if (new ServiceImpl().checkLogin(sql, parameters) && vcode.equalsIgnoreCase(cscode)) {
				MyCar mycar = new MyCar();
				request.getSession().setAttribute("mycar", mycar);
				User user1 = new ServiceImpl().getUserByName(username);
				request.getSession().setAttribute("user", user1);
				request.getSession().setAttribute("Page", new Page(1,6,new ServiceBookImpl().getBookCount()));
				ArrayList<Book> book = new ServiceBookImpl().getBookByPage(0, 12);
				request.setAttribute("book", book);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			} else {
				// 给用户提示，输入错误，让用户重新输入
				String script = "<script>alert('用户名或密码或验证码错误，请重新登陆');location.href='login.jsp'</script>";
				response.getWriter().println(script);
			}
		}
	}
}
