package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Role;
import com.revature.util.HibernateUtil;

public class RoleRepository extends CrudRepository<Role>{


	@Override
	public Role findById(int id) {
		Session ses = HibernateUtil.getSession();
		Role role = ses.get(Role.class, id);
		return role;
	}

	@Override
	public List<Role> findAll() {
		Session ses = HibernateUtil.getSession();
		List<Role> roles = ses.createQuery("from Role", Role.class).list();
		return roles;
	}



}
