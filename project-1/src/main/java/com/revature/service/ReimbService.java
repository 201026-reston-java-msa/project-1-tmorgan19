package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbRepository;
import com.revature.dao.StatusRepository;
import com.revature.dao.TypeRepository;
import com.revature.dao.UserRepository;
import com.revature.model.Reimbursement;
import com.revature.model.Status;
import com.revature.model.Type;
import com.revature.model.User;

public class ReimbService {

	public static void generateReimbursement(String username, double amount, String typename, String description) {
		User author = new UserRepository().findByUsername(username);
		Status status = new StatusRepository().findById(1);
		Type type;
		TypeRepository tr = new TypeRepository();
		
		if (typename.equalsIgnoreCase("Lodging")) {
			type = tr.findById(1);
		} else if (typename.equalsIgnoreCase("Travel")) {
			type = tr.findById(2);
		} else if (typename.equalsIgnoreCase("Food")) {
			type = tr.findById(3);
		} else {
			type = tr.findById(4);
		}
		Reimbursement r = new Reimbursement(amount, author, description, status, type);
		new ReimbRepository().save(r);
	}
	
	public static List<Reimbursement> filterStatusByUser(String username, int statusId){
		User author = new UserRepository().findByUsername(username);
		List<Reimbursement> reimbursementsByStatus = new ReimbRepository().findByStatus(statusId);
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		for (Reimbursement r : reimbursementsByStatus) {
			if (r.getAuthor().getUserId() == author.getUserId()) {
				reimbursements.add(r);
			}
		}
		return reimbursements;
	}
	
}
