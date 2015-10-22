package edu.csupomona.cs480.data;

import java.util.ArrayList;
import java.util.List;

public class Bookmarks {
	
	/** The name of the bookmark */
	private String name;
	/** The list of URLs the user has bookmarked */
	private List<String> urls = new ArrayList<>();
	
	public Bookmarks(String name) {
		this.name = name;
	}
	
	/** Creates the Bookmark object and adds an initial url to the 
	 * url list
	 * 
	 * @param url
	 */
	public Bookmarks(String name, String url) {
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
	 * @param index
	 * @return 
	 */
	public int remove(int index) {
		urls.remove(index);
		return getUrlCount();
	}
}
