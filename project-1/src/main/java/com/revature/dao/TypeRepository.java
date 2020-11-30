package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Type;
import com.revature.util.HibernateUtil;

public class TypeRepository extends CrudRepository<Type> {

	@Override
	public Type findById(int id) {
		Session ses = HibernateUtil.getSession();
		Type type = ses.get(Type.class, id);
		return type;
	}

	@Override
	public List<Type> findAll() {
		Session ses = HibernateUtil.getSession();
		List<Type> types = ses.createQuery("from Type", Type.class).list();
		return types;
	}

	
}
