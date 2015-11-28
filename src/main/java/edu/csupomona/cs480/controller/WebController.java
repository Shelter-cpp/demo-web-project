package edu.csupomona.cs480.controller;

import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.MoreObjects;

import edu.csupomona.cs480.Sheltercpp;
import edu.csupomona.cs480.data.Admin;
import edu.csupomona.cs480.data.Bookmark;
import edu.csupomona.cs480.data.BookmarkBuilder;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.UserBuilder;
import edu.csupomona.cs480.data.provider.FSUserManager;
import edu.csupomona.cs480.data.provider.UserManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link Sheltercpp} class.
	 */
	@Autowired
	private UserManager userManager;
	
	//add url to a bookmark for user
	@RequestMapping(value = "/edit-bookmark-ajs/addUrl", method = RequestMethod.POST)
	void addUrl(
			@RequestParam("userId") String id,
			@RequestParam("bookmarkIndex") String bookmarkIndex,
			@RequestParam("url") String newUrl) {
		User user = userManager.getUser(id);
		user.getBookmark(Integer.parseInt(bookmarkIndex)).addUrl(newUrl);
		userManager.updateUser(user);
		System.out.println("Add url: " + newUrl);
	}
	
	//delete url from a bookmark for user
	@RequestMapping(value = "/edit-bookmark-ajs/deleteUrl", method = RequestMethod.POST)
	void deleteUrl(
			@RequestParam("userId") String id,
			@RequestParam("bookmarkIndex") String bookmarkIndex,
			@RequestParam("urlIndex") String urlIndex) {
		User user = userManager.getUser(id);
		user.getBookmark(Integer.parseInt(bookmarkIndex)).remove(Integer.parseInt(urlIndex));
		userManager.updateUser(user);
		System.out.println("Delete url at index: " + urlIndex);
	}
	
	//delete bookmark from user
	@RequestMapping(value = "/edit-bookmark-ajs/deleteBookmark", method = RequestMethod.POST)
	void deleteBookmark(
			@RequestParam("userId") String id,
			@RequestParam("bookmarkIndex") String bookmarkIndex) {
		User user = userManager.getUser(id);
		user.deleteBookmark(Integer.parseInt(bookmarkIndex));
		userManager.updateUser(user);
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	/*@RequestMapping(value = "/cs480/user/delete/{userId}", method = RequestMethod.GET)
	User deleteUser(
			@PathVariable("userId") String userId) {
		User returnUser = userManager.getUser(userId);
		userManager.deleteUser(userId);
		return returnUser;
	}*/
	
	//loads urls for edit-bookmark-ajs.html page
	@RequestMapping(value = "/loadUrls/", method = RequestMethod.POST)
	List<String> listURLS(
			@RequestParam("userId") String userId,
			@RequestParam("bookmarkIndex") String bookmarkIndex) {
		return userManager.getUser(userId).getBookmark(Integer.parseInt(bookmarkIndex)).getUrls();
	}
	
	//loads bookmarks for user-home-ajs.html
	@RequestMapping(value = "/loadBookmarks/", method = RequestMethod.POST)
	List<String> listBookmarks(
			@RequestParam("userId") String userId) {
		return userManager.getUser(userId).getBookmarkNames();
	}
	
	//checks login
	@RequestMapping(value = "/checkForNewUser/", method = RequestMethod.POST)
	int checkForNewUser(
			@RequestParam("password") String pass,
			@RequestParam("userId") String userId) {
		
		System.out.println("attempt login: username: |" + userId + "| password: |" + pass + "|");
		
		if(userId == "undefined" || pass.length()==0)
			return 3;
		
		if(userId.contains("?") || userId.contains("=") || userId.contains("/") || userId.contains("\\") || userId.contains("&")){
			return 4;
		}
		
		User user = userManager.getUser(userId);
		if(user == null) {
			user = new User(userId, pass);
			userManager.updateUser(user);
			System.out.println("Added new userId: " + user.getUsername() + " password: " + user.getPassword());
			return 0;
		}
		//correct username/password
		if(user.checkPassword(pass)){
			System.out.println("returning 1 (correct pass) username logged in: |" + user.getUsername() + "|");
			return 1;
		}//correct username, incorrect password
		else{
			System.out.println("returning 2 (incorrect pass) userpass: |" + user.getPassword() + "| attempt pass: |" + pass+"|");
			return 2;
		}
	}
	
	//adds new bookmark for user
	@RequestMapping(value = "{user}/addBookmark/{bookmarkName}", method = RequestMethod.GET)
	int addBookmarkToUser(@PathVariable("user") String username,@PathVariable("bookmarkName") String bookmarkName) {
		User user = userManager.getUser(username);
		Bookmark tempBookmark = new BookmarkBuilder().name(bookmarkName).build();
		user.addBookmark(tempBookmark);
		userManager.updateUser(user);
		
		return user.getBookmarkCount();
	}
	
	//returns bookmark count for user
	@RequestMapping(value = "{user}/getBookmarkCount/", method = RequestMethod.GET)
	int getBookmarkCount(@PathVariable("user") String username) {
		return userManager.getUser(username).getBookmarkCount();
	}
	
}