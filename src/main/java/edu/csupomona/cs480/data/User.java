package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.junit.Ignore;


/**
 * The basic user object.
 */
public class User implements UserInterface {

	/** The unique user Id */
    private String username;
    
    /** The user's password  */
    private String password;
    
    /** The timestamp when the user is being created */
    private String creationTime = new Date(System.currentTimeMillis()).toString();
    
    /** The list of bookmarks that the user has created */
    private List<Bookmark> bookmarks = new ArrayList<>();
    
    //placeholder for JSON data
    //DO NOT USE
    private int bookmarkCount;
    
    /** Creates a user given their username and password
     * 
     * @param username
     * @param password
     */
    public User(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
    public User(String username) {
    	this.username = username;
    }
    
    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPassword() {
    	return password;
    }

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}
	
	public List<String> getBookmarkNames()
	{
		List<String> temp = new ArrayList<>();
		for(int i=0; i<bookmarks.size(); i++)
		{
			temp.add(bookmarks.get(i).getName());
		}
		return temp;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	/** Returns true if the given password is the same as the user's password
	 * 
	 * @param testPassword
	 * @return
	 */
	public boolean checkPassword(String testPassword) {
		return password.equals(testPassword);
	}
	
	/** Returns the bookmark at the given index
	 * 
	 * @param index
	 * @return
	 */
	public Bookmark getBookmark(int bookmarkNumber) {
		return bookmarks.get(bookmarkNumber);
	}
	
	/** Returns the number of bookmarks this user has created
	 * 
	 * @return
	 */
	public int getBookmarkCount() {
		return bookmarks.size();
	}
	
	/** Adds a bookmark to the end of the list of bookmarks
	 * 
	 * @param newBookmark
	 */
	public int addBookmark(Bookmark newBookmark) {
		bookmarks.add(newBookmark);
		return getBookmarkCount();
	}
	
	/** Deletes the bookmark at the given index
	 * 
	 * @param index
	 */
	public int deleteBookmark(int index) {
		bookmarks.remove(index);
		return getBookmarkCount();
	}
	
	/** Swaps the position of the bookmarks at the two given indexes
	 * 
	 * @param index1
	 * @param index2
	 */
	public void swapBookmarks(int index1, int index2) {
		Bookmark temp1 = bookmarks.get(index1);
		Bookmark temp2 = bookmarks.get(index2);
		bookmarks.set(index1, temp2);
		bookmarks.set(index2, temp1);
	}
	
	/** Returns a formatted string with the information of the user
	 * 
	 */
	public String toString() {
		String returnString = "";
		returnString += "Username:" + username + "; Password: " + password + "; # of Bookmarks: " + getBookmarkCount() + ";\n Bookmarks: ";
		for(int i = 0; i < getBookmarkCount(); i++) {
			Bookmark bookmark = getBookmark(i);
			returnString += "\n" + bookmark.getName() + "- ";
			List<String> urls = bookmark.getUrls();
			for(int j = 0; j < urls.size(); j++) {
				returnString += "\n\t" + urls.get(j);
			}
		}
		return returnString;
	}
}