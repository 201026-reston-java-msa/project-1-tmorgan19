package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Role;
import com.revature.util.HibernateUtil;

public class RoleRepository implements CrudRepository<Role>{

	@Override
	public void save(Role t) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(t);
		tx.commit();		
	}

	@Override
	public List<Role> findAll(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Role t) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(t);
		tx.commit();		
	}

}
