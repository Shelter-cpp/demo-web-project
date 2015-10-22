package edu.csupomona.cs480.data;

import org.junit.*;

public class UserTest {

	public static void main(String[] args) {
		User testUser  =new User("TestUser", "TestPassword");
		String testUrl1 = "www.google.com";
		String testUrl2 = "www.facebook.com";
		String testUrl3 = "www.github.com";
		String testUrl4 = "www.youtube.com";
		Bookmarks testBookmark1 = new Bookmarks("Bookmark 1");
		testBookmark1.addUrl(testUrl1);
		testBookmark1.addUrl(testUrl2);
		testBookmark1.addUrl(testUrl3);
		testBookmark1.addUrl(testUrl4);
		Bookmarks testBookmark2 = new Bookmarks("Bookmark 2");
		testBookmark2.addUrl(testUrl2);
		testBookmark2.addUrl(testUrl3);
		Bookmarks testBookmark3 = new Bookmarks("Bookmark 3");
		testBookmark3.addUrl(testUrl1);
		testBookmark3.addUrl(testUrl2);
		testBookmark3.addUrl(testUrl3);
		Bookmarks testBookmark4 = new Bookmarks("Bookmark 4");
		testBookmark4.addUrl(testUrl1);
		testBookmark4.addUrl(testUrl4);
		testUser.addBookmark(testBookmark1);
		testUser.addBookmark(testBookmark2);
		testUser.addBookmark(testBookmark3);
		testUser.addBookmark(testBookmark4);
		
		System.out.println(testUser.toString());
		
		testUser.swapBookmarks(0, 2);
		
		System.out.println(testUser.toString());
	}
	
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
		User testUser  =new User("TestUser", "TestPassword");
		Bookmarks testBookmark1 = new Bookmarks("Bookmark 1");
		Bookmarks testBookmark2 = new Bookmarks("Bookmark 2");
		Bookmarks testBookmark3 = new Bookmarks("Bookmark 3");
		Bookmarks testBookmark4 = new Bookmarks("Bookmark 4");
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
		Bookmarks testBookmark1 = new Bookmarks("Bookmark 1");
		testBookmark1.addUrl(testUrl1);
		testBookmark1.addUrl(testUrl2);
		testBookmark1.addUrl(testUrl3);
		testBookmark1.addUrl(testUrl4);
		Bookmarks testBookmark2 = new Bookmarks("Bookmark 2");
		testBookmark2.addUrl(testUrl2);
		testBookmark2.addUrl(testUrl3);
		Bookmarks testBookmark3 = new Bookmarks("Bookmark 3");
		testBookmark3.addUrl(testUrl1);
		testBookmark3.addUrl(testUrl2);
		testBookmark3.addUrl(testUrl3);
		Bookmarks testBookmark4 = new Bookmarks("Bookmark 4");
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
		Bookmarks testBookmark1 = new Bookmarks("Bookmark 1");
		Bookmarks testBookmark2 = new Bookmarks("Bookmark 2");
		Bookmarks testBookmark3 = new Bookmarks("Bookmark 3");
		Bookmarks testBookmark4 = new Bookmarks("Bookmark 4");
		testUser.addBookmark(testBookmark1);
		testUser.addBookmark(testBookmark2);
		testUser.addBookmark(testBookmark3);
		testUser.addBookmark(testBookmark4);
		testUser.deleteBookmark(2);
		Assert.assertEquals(3, testUser.getBookmarkCount());
	}
}
