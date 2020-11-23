package com.revature;

import com.revature.dao.RoleRepository;
import com.revature.dao.UserRepository;
import com.revature.model.Role;
import com.revature.model.User;

public class Driver {

	public static void main(String[] args) {

		initialValues();
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
		
	}
}

