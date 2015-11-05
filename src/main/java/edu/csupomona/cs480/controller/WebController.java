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
import edu.csupomona.cs480.data.User;
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
	@Autowired
	private FSUserManager testManager;
	

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User(id, "password");
		//user.setUsername(id);
		//user.setMajor(major);
		//user.setName(name);
		userManager.updateUser(user);
		return user;
	}
	

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/user/delete/{userId}", method = RequestMethod.GET)
	User deleteUser(
			@PathVariable("userId") String userId) {
		User returnUser = userManager.getUser(userId);
		userManager.deleteUser(userId);
		return returnUser;
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}
	
	/**
	 * This is a test for inputing data into user 
	 * 
	 */
	@RequestMapping(value = "/preset1/list", method = RequestMethod.GET)
	List<String> listURLS() {
		User user1 = new User("user1", "password1");
		String testUrl1 = "www.google.com";
		String testUrl2 = "www.facebook.com";
		String testUrl3 = "www.github.com";
		String testUrl4 = "www.youtube.com";
		Bookmark testBookmark1 = new Bookmark("Bookmark 1");
		testBookmark1.addUrl(testUrl1);
		testBookmark1.addUrl(testUrl2);
		testBookmark1.addUrl(testUrl3);
		testBookmark1.addUrl(testUrl4);
		
		user1.addBookmark(testBookmark1);
		
		userManager.updateUser(user1);
		System.out.print("\n" + user1.getUsername() + ": " + testBookmark1.getName() + ": " + user1.getBookmark(0).getUrls() +"\n");
		//should print list of urls in table, ****html doesn't load****
		//ask how to make url take variables so we don't have to make 8 of them
		return user1.getBookmark(0).getUrls();
	}
	
	/** 
	 * Displays all of the information about the given user
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
	String getUserInfo(@PathVariable("username") String username) {
		User newUser = new User(username, "password");
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
		newUser.addBookmark(testBookmark1);
		newUser.addBookmark(testBookmark2);
		newUser.addBookmark(testBookmark3);
		newUser.addBookmark(testBookmark4);
		userManager.updateUser(newUser);
		
		String userInfo = userManager.getUser(username).toString();
		return userInfo;
	}
	
	@RequestMapping(value = "/admin/{password}/getall", method = RequestMethod.GET)
	List<User> getAdminPage(@PathVariable("password") String password) {
		Admin admin = new Admin(password);
		return admin.getAllUsers();
	}
	
	@RequestMapping(value = "/levl/test/{input1}/get/{input2}", method = RequestMethod.GET)
	void testTwo(
			@PathVariable("input1") String name, @PathVariable("input2") String price) {
		System.out.println(name + " " + price);
		//return admin.getAllUsers();
	}
	
	
	/**
	 * This API tests to see if Alex knows what he is doing.
	 * 
	 * @return
	 */
	/*
	@RequestMapping(value = "/cs480/alextest", method = RequestMethod.GET)
	ModelAndView alexTest() {
		ModelAndView modelAndView = new ModelAndView("test-home");
		return modelAndView;
		testManager.updateTestUser();
		User user;
		user = testManager.getTestUser();
		return user;
	}
	*/
	
	/**
	 * This API tests to see if Daniel knows what he is doing.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cs480/danieltest", method = RequestMethod.GET)
	String danielTest() {
		String myString = "Ey b0ss, give me the code please.";
		//for assignment 5, apparently all it does is print 000000 to console
		//when the url is accessed
		DescriptiveStatistics stats = new DescriptiveStatistics();
		int a[] = new int[6];
		for( int i = 0; i < a.length; i++) {
	        stats.addValue(a[i]);
	        System.out.print(a[i]);
		}
	    return myString;
	}
	
     
     /**
      * This API tests to see if Ian knows what he is doing.
      *
      * @return
      */
     @RequestMapping(value = "/cs480/iantest", method = RequestMethod.GET)
     String ianTest() {
          String testString = "" + Math.pow(2, .5) + " " + MoreObjects.toStringHelper(this).toString();
          return testString;
     }
}