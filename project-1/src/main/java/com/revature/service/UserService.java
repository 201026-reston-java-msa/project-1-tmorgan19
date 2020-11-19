package com.revature.service;

public class UserService {

	// Credentials hard coded in until DB established
	public static boolean verifyLogin(String username, String password) {
		
		if (username != null && password != null) {
			return (username.equalsIgnoreCase("User1") && password.equals("Password1"));
		} else {
			return false;
		}
	}
}
