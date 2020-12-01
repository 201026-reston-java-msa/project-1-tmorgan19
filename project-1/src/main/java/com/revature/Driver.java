package com.revature;

import java.util.List;

import com.revature.dao.ReimbRepository;
import com.revature.dao.RoleRepository;
import com.revature.dao.StatusRepository;
import com.revature.dao.TypeRepository;
import com.revature.dao.UserRepository;
import com.revature.model.Reimbursement;
import com.revature.model.Role;
import com.revature.model.Status;
import com.revature.model.Type;
import com.revature.model.User;
import com.revature.service.ReimbService;

public class Driver {

	public static void main(String[] args) {

//		initialValues();
//		ReimbRepository rr = new ReimbRepository();
//		List<Reimbursement> reimbs = rr.findByStatus(1);
//		for (Reimbursement r : reimbs) {
//			System.out.println(r.toString());
		initialManagerValues();
	}
	
	
	private static void initialManagerValues() {
		RoleRepository rr = new RoleRepository();
		Role r2 = rr.findById(2);
		
		String username = "manager";
		String password = "password";
		String firstName = "Man";
		String lastName = "Ager";
		String email = "manager@mail.com";
		User u3 = new User(username, password, firstName, lastName, email, r2);
		
		UserRepository ur = new UserRepository();
		ur.save(u3);
	}


	public static void initialValues() {
		Role r1 = new Role(1, "Employee");
		Role r2 = new Role(2, "Manager");
		
		RoleRepository rr = new RoleRepository();
		
		rr.save(r1);
		rr.save(r2);
		
		String username = "example";
		String password = "password";
		String firstName = "First";
		String lastName = "Last";
		String email = "email@mail.com";
		
		User u1 = new User(username, password, firstName, lastName, email, r1);
		User u2 = new User("example2", password, firstName, lastName, email, r1);
		
		UserRepository ur = new UserRepository();
		
		ur.save(u1);
		ur.save(u2);
		
		List<User> userList = ur.findAll();
		for (User u : userList) {
			System.out.println(u.toString());
		}
		System.out.println("find by username" + ur.findByUsername(username).toString());
		
		Type t1 = new Type(1, "Lodging");
		Type t2 = new Type(2, "Travel");
		Type t3 = new Type(3, "Food");
		Type t4 = new Type(4,"Other");
		
		TypeRepository tr = new TypeRepository();
		tr.save(t1);
		tr.save(t2);
		tr.save(t3);
		tr.save(t4);
		
		Status s1 = new Status(1, "Pending");
		Status s2 = new Status(2, "Approved");
		Status s3 = new Status(3, "Denied");
		
		StatusRepository sr = new StatusRepository();
		sr.save(s1);
		sr.save(s2);
		sr.save(s3);
		
//		ReimbService.generateReimbursement(100, new UserRepository().findById(1), "test reimbursement");
	}
	
}

