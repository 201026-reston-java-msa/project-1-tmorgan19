package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	
//	@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
//	private List<User> users = new ArrayList<>();
	
	public Role() {
		super();
	}
	
	public Role(int roleId, String roleName, List<User> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
//		this.users = users;
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

//	public List<User> getUsers() {
////		return users;
//	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	
	
	
}
