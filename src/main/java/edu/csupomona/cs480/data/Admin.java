package edu.csupomona.cs480.data;

import java.util.List;

import edu.csupomona.cs480.data.provider.*;

public class Admin {
	
	private static Admin staticAdmin;
	private String username = "Admin";
	private static String password = "password";
	private UserManager manager = new FSUserManager();
	
	//Admin instance is obtained using the static getInstance method
	private Admin() {
	}
	
	//uses Singleton pattern to allow only one Admin class
	public static Admin getInstance(String password) {
		//lazy instantiation
		if(staticAdmin == null && checkPassword(password)) {
			staticAdmin = new Admin();
		}
		return staticAdmin;
	}
	
	public List<User> getAllUsers() {
		return manager.listAllUsers();
	}
	
	public static boolean checkPassword(String testPassword) {
		return password.equals(testPassword);
	}
}
