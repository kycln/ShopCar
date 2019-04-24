package com.bbu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.User;
import com.bbu.service.impl.ServiceImpl;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 用ajax判断用户名是否存在，使得User表中的用户名不重名
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
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("开始");
		String username = request.getParameter("username");
		User user = new User();
		user = new ServiceImpl().getUserByName(username);
		System.out.println(username);
		System.out.println(user);
		String username1 = user.getUsername();
		if(null != username1 && username1.equals(username)) {
			response.getWriter().print("用户名已存在！");
		}else {
			response.getWriter().print("用户名合法！");
		}
		System.out.println("结束");
	}

}
