package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.util.HibernateUtil;

public abstract class CrudRepository<T> {

	public void save(T t) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(t);
		tx.commit();		
	}

	public abstract List<T> findAll();

	public abstract T findById(int id);

	public void update(T t) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(t);
		tx.commit();		
	}
}
