package edu.csupomona.cs480.data;

import java.util.List;

import edu.csupomona.cs480.data.provider.*;

public class Admin {
	
	String username = "Admin";
	String password;
	UserManager manager = new FSUserManager();
	
	public Admin(String password) {
		this.password = password;
	}
	
	public List<User> getAllUsers() {
		return manager.listAllUsers();
	}
	
	public boolean checkPassword(String testPassword) {
		return password.equals(testPassword);
	}
}
