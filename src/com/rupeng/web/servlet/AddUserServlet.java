package com.rupeng.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.domain.User;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// ---------------执行权限检查-------------------

		User user = (User) request.getSession().getAttribute("user");
		// if (user == null) {
		// response.getWriter().print("你还没有登录，请先登录");
		// return;
		// }
		// String uri = request.getRequestURI();
		// String url = request.getRequestURL().toString();
		//
		// System.out.println("uri : " + uri);
		// System.out.println("url : " + url);
		//
		// boolean result = user.checkPermission(uri);
		//
		// if (!result) {
		// response.getWriter().print(user.getUsername() + ",你还没添加用户的权限");
		// return;
		// }
		// -------------------执行业务逻辑----------------------

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// ......执行添加用户的逻辑
		response.getWriter().print(
				"操作用户是：" + user.getUsername() + " , 添加 " + username + " 用户成功");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
