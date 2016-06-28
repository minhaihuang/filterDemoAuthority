package com.rupeng.domain;

//代表一个权限，
public class Permission {

	private int id;
	private String authPath;// 本权限对应的请求路径

	public boolean checkPermission(String path) {

		return path.endsWith(authPath);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthPath() {
		return authPath;
	}

	public void setAuthPath(String authPath) {
		this.authPath = authPath;
	}

}
