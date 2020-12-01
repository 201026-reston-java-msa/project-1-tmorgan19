package com.revature.service;

import java.util.List;

import com.revature.dao.UserRepository;
import com.revature.model.User;

public class UserService {

	public static boolean verifyLogin(String username, String password) {
		
		if (username != null && password != null) {
			UserRepository ur = new UserRepository();
			User u = ur.findByUsername(username);
			if (u != null) {
				return (username.equalsIgnoreCase(u.getUsername()) && password.equals(u.getPassword()));
			} else {
				System.out.println("Username not found in database");
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isManager(String username) {
		UserRepository ur = new UserRepository();
		User u = ur.findByUsername(username);
		if (u.getRole().getRoleName().equalsIgnoreCase("Manager")) {
			return true;
		}
		else {
			return false;
		}
	}

	public static User getUserInfo(String username) {
		return new UserRepository().findByUsername(username);
	}

	public static void updateUser(String username, String newFirstName, String newLastName, String newEmail) {
		UserRepository ur = new UserRepository();
		User u = ur.findByUsername(username);
		
		boolean change = false;
		if (!u.getFirstName().equals(newFirstName)) {
			u.setFirstName(newFirstName);
			change = true;
		}
		if (!u.getLastName().equals(newLastName)) {
			u.setLastName(newLastName);
			change = true;
		}
		if (!u.getEmail().equals(newEmail)) {
			u.setEmail(newEmail);
			change = true;
		}
		
		if (change) {
			ur.update(u);
		}

	}

	public static List<User> getAllUsers() {
		return new UserRepository().findAll();
	}
}
