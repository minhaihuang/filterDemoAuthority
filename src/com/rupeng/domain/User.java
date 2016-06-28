package com.rupeng.domain;

import java.util.ArrayList;
import java.util.List;

//用户，一个用户可以有多个角色，用户并不和权限直接相关
public class User {

	private String username;
	private List<Role> roles;

	// 检查权限,只要有一个角色的权限匹配uri，就表明此用户拥有此uri的权限
	public boolean checkPermission(String uri) {
		if (uri == null) {
			return false;
		}
		if (roles == null) {
			return false;
		}
		for (Role role : roles) {
			if (role != null) {
				boolean temp = role.checkPermission(uri);
				if (temp) {
					return true;
				}
			}
		}
		return false;
	}

	public void addRole(Role role) {
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		roles.add(role);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
