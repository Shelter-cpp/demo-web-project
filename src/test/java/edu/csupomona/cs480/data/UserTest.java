package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void testUserName() {
		User user = new User("TestUser", "TestPassword");
		Assert.assertEquals("TestUser", user.getUsername());
		
	}
	
	@Test
	public void testPassword() {
		User user = new User("TestUser", "TestPassword");
		Assert.assertEquals("TestPassword", user.getPassword());
	}
	
	@Test
	public void testBookmarkCount() {
		User testUser = null;
		Assert.assertEquals(null, testUser);
		testUser  =new User("TestUser", "TestPassword");
		Bookmark testBookmark1 = new Bookmark("Bookmark 1");
		Bookmark testBookmark2 = new Bookmark("Bookmark 2");
		Bookmark testBookmark3 = new Bookmark("Bookmark 3");
		Bookmark testBookmark4 = new Bookmark("Bookmark 4");
		testUser.addBookmark(testBookmark1);
		testUser.addBookmark(testBookmark2);
		testUser.addBookmark(testBookmark3);
		testUser.addBookmark(testBookmark4);
		Assert.assertEquals(4, testUser.getBookmarkCount());
		
	}
	
	@Test
	public void testSwapBookmarks() {
		User testUser  =new User("TestUser", "TestPassword");
		String testUrl1 = "www.google.com";
		String testUrl2 = "www.facebook.com";
		String testUrl3 = "www.github.com";
		String testUrl4 = "www.youtube.com";
		Bookmark testBookmark1 = new Bookmark("Bookmark 1");
		testBookmark1.addUrl(testUrl1);
		testBookmark1.addUrl(testUrl2);
		testBookmark1.addUrl(testUrl3);
		testBookmark1.addUrl(testUrl4);
		Bookmark testBookmark2 = new Bookmark("Bookmark 2");
		testBookmark2.addUrl(testUrl2);
		testBookmark2.addUrl(testUrl3);
		Bookmark testBookmark3 = new Bookmark("Bookmark 3");
		testBookmark3.addUrl(testUrl1);
		testBookmark3.addUrl(testUrl2);
		testBookmark3.addUrl(testUrl3);
		Bookmark testBookmark4 = new Bookmark("Bookmark 4");
		testBookmark4.addUrl(testUrl1);
		testBookmark4.addUrl(testUrl4);
		testUser.addBookmark(testBookmark1);
		testUser.addBookmark(testBookmark2);
		testUser.addBookmark(testBookmark3);
		testUser.addBookmark(testBookmark4);
		testUser.swapBookmarks(0, 2);
		Assert.assertEquals("Bookmark 3", testUser.getBookmarks().get(0).getName());
		Assert.assertEquals("Bookmark 1", testUser.getBookmarks().get(2).getName());
	}
	
	@Test
	public void testDeleteBookmark() {
		User testUser  =new User("TestUser", "TestPassword");
		Bookmark testBookmark1 = new Bookmark("Bookmark 1");
		Bookmark testBookmark2 = new Bookmark("Bookmark 2");
		Bookmark testBookmark3 = new Bookmark("Bookmark 3");
		Bookmark testBookmark4 = new Bookmark("Bookmark 4");
		testUser.addBookmark(testBookmark1);
		testUser.addBookmark(testBookmark2);
		testUser.addBookmark(testBookmark3);
		testUser.addBookmark(testBookmark4);
		testUser.deleteBookmark(2);
		Assert.assertEquals(3, testUser.getBookmarkCount());
	}
}
