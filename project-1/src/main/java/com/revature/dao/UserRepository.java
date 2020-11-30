package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserRepository extends CrudRepository<User> {

	public User findByUsername(String username) {
		// throws IndexOutOfBoundsException if no results from query
		Session ses = HibernateUtil.getSession();
		
		User user = null;
		
		Query query = ses.createQuery("from User where username = :u", User.class);
		query.setParameter("u", username);
		query.setMaxResults(1);
		List<User> results = query.list();
		if (!results.isEmpty()) {
			user=results.get(0);
		}
		
		return user;
	}

	@Override
	public List<User> findAll() {
		Session ses = HibernateUtil.getSession();
		List<User> users = ses.createQuery("from User", User.class).list();
		return users;
	}

	@Override
	public User findById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, id);
		return user;
	}

}
