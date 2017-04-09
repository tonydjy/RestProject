package com.tv.model;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {
	private Long roleid;
	private String roleName;
    private Set<User> users;
	
	public Long getRoleid() {
		return this.roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<User> getUsers() {
		return this.users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	

}
