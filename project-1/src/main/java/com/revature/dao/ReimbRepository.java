package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbRepository extends CrudRepository<Reimbursement>{

	@Override
	public List<Reimbursement> findAll() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> reimbursements = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return reimbursements;
	}

	@Override
	public Reimbursement findById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement reimbursement = ses.get(Reimbursement.class, id);
		return reimbursement;
	}

	public List<Reimbursement> findByStatus(int statusId){
		Session ses = HibernateUtil.getSession();
		Query query = ses.createQuery("from Reimbursement where status_id = :id");
		query.setParameter("id", statusId);
		List<Reimbursement> reimbursements = query.list();
		return reimbursements;
	}
	


}
