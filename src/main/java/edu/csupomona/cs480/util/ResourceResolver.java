package edu.csupomona.cs480.util;

import java.io.File;

import edu.csupomona.cs480.data.User;

/**
 * This is an utility class to help file locating.
 */
public class ResourceResolver {

	/** The base folder to store all the data used by this project. */
	private static final String BASE_DIR = System.getProperty("user.home") + "/cs480";

	/**
	 * Get the file used to store the user object JSON
	 *
	 * @param 
	 * @return
	 */
	public static File getUserFile() {
		File file = new File(BASE_DIR + "/" + "user-map.json");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
	
	/**
	 * Get the file used to store the user object JSON
	 *
	 * @param user
	 * @return
	 */
	public static File getUserFile(User user) {
		File file = new File(BASE_DIR + "/" + user.getUsername() + "/user-map.json");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
	
	public static File getTestFile() {
		File file = new File(BASE_DIR + "/" + "test.json");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return file;
	}
}
