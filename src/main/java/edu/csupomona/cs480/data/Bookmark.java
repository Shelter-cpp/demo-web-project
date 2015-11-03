package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

public class Bookmark implements BookmarkInterface{
	
	/** The name of the bookmark */
	private String name;
	/** The list of URLs the user has bookmarked */
	private List<String> urls = new ArrayList<>();
	
	private int urlCount;
	
	public Bookmark() {}
	
	public Bookmark(String name) {
		this.name = name;
	}
	
	/** Creates the Bookmark object and adds an initial url to the 
	 * url list
	 * 
	 * @param url
	 */
	public Bookmark(String name, String url) {
		this.name = name;
		urls.add(url);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getUrls() {
		return urls;
	}
	
	/** Returns the number of urls the bookmark has
	 * 
	 * @return
	 */
	public int getUrlCount() {
		return urls.size();
	}
	
	/** Adds a url to the list of urls
	 * Returns the number of urls after the add
	 * @param url
	 * @return
	 */
	public int addUrl(String url) {
		urls.add(url);
		return getUrlCount();
	}
	
	/** Removes the url at the given index
	 * Returns the number of urls remaining
	 * ((we could possibly change the param to be the string name of the url))
	 * @param index
	 * @return 
	 */
	public int remove(int index) {
		urls.remove(index);
		return getUrlCount();
	}
	
	//I don't think we will need this, we can just remove then add
	public boolean changeUrl(int index,String newUrl) {
		if(index < urls.size()){
			urls.set(index, newUrl);
			return true;
		}
		else {
			return false;
		}
	}
}
