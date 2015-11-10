package edu.csupomona.cs480.data.UserManager;

import org.junit.Test;

import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.FSUserManager;
import junit.framework.Assert;

public class FSUserTest {
	/*
	//for Daniel assignment 6, check creation and deletion of user
	@SuppressWarnings("deprecation")
	@Test
	public void deleteUserTest(){
		User user = null;
		Assert.assertNull(user);
		user = new User("name", "pass");
		Assert.assertNotNull(user);
		FSUserManager um = new FSUserManager();
		um.updateUser(user);
		Assert.assertFalse(um.listAllUsers().isEmpty()); 
		um.deleteUser("name");
		Assert.assertTrue(um.listAllUsers().isEmpty());
	}*/
}
