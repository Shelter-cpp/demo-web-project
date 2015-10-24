package edu.csupomona.cs480.data;

public interface BookmarkInterface {
	
	public int addUrl(String url);
	public boolean changeUrl(int index, String newUrl);
	public int remove(int index);
	public int getUrlCount();

}
