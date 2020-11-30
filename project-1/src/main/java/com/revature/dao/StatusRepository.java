package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.Status;
import com.revature.util.HibernateUtil;

public class StatusRepository extends CrudRepository<Status>{

	@Override
	public Status findById(int id) {
		Session ses = HibernateUtil.getSession();
		Status status = ses.get(Status.class, id);
		return status;
	}

	@Override
	public List<Status> findAll() {
		Session ses = HibernateUtil.getSession();
		List<Status> statuses = ses.createQuery("from Status", Status.class).list();
		return statuses;
	}

}
