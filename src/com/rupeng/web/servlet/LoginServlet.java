package com.rupeng.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.domain.Permission;
import com.rupeng.domain.Role;
import com.rupeng.domain.User;

//执行添加用户的操作，需要进行权限检查
public class LoginServlet extends HttpServlet {

	// 模拟使用，真实项目中不可用在Servlet中定义普通字段
	private User zhangsan;
	private User lisi;

	public void init() throws ServletException {
		// 构造zhangsan用户对象
		zhangsan = new User();
		zhangsan.setUsername("zhangsan");

		// 构造一个admin管理员角色，并把角色添加到zhangsan用户中
		Role adminRole = new Role(10000, "admin");// 10000表示角色等级，在本例中没有意义，admin是角色的名称

		Permission permission = new Permission();
		permission.setAuthPath("AddUserServlet.auth");// 此权限表示AddUserServlet.auth的访问权限

		adminRole.addPermission(permission);
		zhangsan.addRole(adminRole);

		// 构造lis用户对象
		lisi = new User();
		lisi.setUsername("lisi");

		// 构造一个普通用户角色，此角色没有特殊的权限
		Role commonRole = new Role(1, "common");
		lisi.addRole(commonRole);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 代表登录的用户是zhangsan还是lisi
		String username = request.getParameter("username");

		// 模拟用户登录
		if ("zhangsan".equals(username)) {
			request.getSession().setAttribute("user", zhangsan);
		} else {
			request.getSession().setAttribute("user", lisi);
		}

		request.getRequestDispatcher("addUser.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
