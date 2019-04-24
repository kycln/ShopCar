package com.bbu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbu.model.User;
import com.bbu.service.impl.ServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html;charse=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String vcode = request.getParameter("vcode");
		String cscode = (String) request.getSession().getAttribute("vscode");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setTelephone(telephone);
		user.setGrade(2);
		boolean flag = false;
		PrintWriter out = response.getWriter();
		if(vcode.equalsIgnoreCase(cscode)) {
			flag = new ServiceImpl().addUser(user);
			if(flag) {
				out.print("<script language='javascript'>alert('用户注册成功！请开始登录');window.location.href='login.jsp';</script>");
			}else {
				out.print("<script language='javascript'>alert('用户注册失败！请重新注册');window.location.href='regist.jsp';</script>");
			}
		}else {
			out.print("<script language='javascript'>alert('验证码错误，请重新注册！');window.location.href='regist.jsp';</script>");
		}
	}

}
