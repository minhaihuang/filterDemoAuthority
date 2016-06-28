package com.rupeng.domain;

import java.util.ArrayList;
import java.util.List;

//代表一个角色，一个角色有角色等级level，有一组权限
public class Role {

	// 角色等级，整数类型，值越大等级越高
	private int level;

	private String rolename;

	private List<Permission> permissions;

	public Role() {
	}

	public Role(int level, String rolename) {
		this.level = level;
		this.rolename = rolename;
	}

	public void addPermission(Permission permission) {
		if (permissions == null) {
			permissions = new ArrayList<Permission>();
		}
		permissions.add(permission);
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public boolean checkPermission(String uri) {
		if (permissions == null) {
			return false;
		}
		for (Permission permission : permissions) {
			if (permission != null) {
				boolean temp = permission.checkPermission(uri);
				if (temp) {
					return true;
				}
			}
		}
		return false;
	}

}
