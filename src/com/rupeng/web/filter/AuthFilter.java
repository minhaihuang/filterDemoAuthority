package com.rupeng.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import com.rupeng.domain.User;

public class AuthFilter implements Filter {

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg1.setContentType("text/html;charset=utf-8");
		HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
		User user = (User) httpServletRequest.getSession().getAttribute("user");

		if (user == null) {
			arg1.getWriter().print("你还没有登录，请先登录");
			return;
		}

		String uri = httpServletRequest.getRequestURI();

		boolean result = user.checkPermission(uri);

		if (result) {
			arg2.doFilter(httpServletRequest, arg1);
		} else {
			arg1.getWriter().print(user.getUsername() + " , 你没有添加用户的权限");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void destroy() {

	}

}
